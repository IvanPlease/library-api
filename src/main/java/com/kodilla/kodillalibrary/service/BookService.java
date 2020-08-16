package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.domain.LibraryStorageEntry;
import com.kodilla.kodillalibrary.exception.BookException;
import com.kodilla.kodillalibrary.mapper.BookMapper;
import com.kodilla.kodillalibrary.service.repository.BookRepository;
import com.kodilla.kodillalibrary.service.repository.LibraryStorageEntryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final LibraryStorageEntryService entryService;
    private final BookRepository repository;
    private final BookMapper mapper;

    public List<BookDto> getAllBooks() {
        return mapper.mapToBookDtoList(repository.findAll());
    }

    public BookDto getBookById(Long bookId) {
        Book fetchedBook = repository.findById(bookId).orElseThrow(() -> new BookException(BookException.ERR_BOOK_NOT_FOUND_EXCEPTION));
        return mapper.mapToBookDto(fetchedBook);
    }

    public BookDto updateBook(BookDto bookDto) {
        if (bookDto.getBookId() != null) {
            isBookExisting(bookDto.getBookId());
        } else {
            throw new BookException(BookException.ERR_BOOK_ID_MUST_BE_NOT_NULL_EXCEPTION);
        }
        Book updatedBook = repository.save(mapper.mapToBook(bookDto));
        return mapper.mapToBookDto(updatedBook);
    }

    public BookDto createBook(BookDto bookDto) {
        if (bookDto.getBookId() == null || bookDto.getBookId() == 0L) {
            Book updatedBook = repository.save(mapper.mapToBook(bookDto));
            BookDto updatedBookDto = mapper.mapToBookDto(updatedBook);
            LibraryStorageEntry entry = LibraryStorageEntry.builder()
                    .copyId(1L)
                    .book(mapper.mapToBook(bookDto))
                    .status(0L)
                    .build();
            entryService.createEntry(mapper.mapToLibraryStorageEntryDto(entry));
            return updatedBookDto;
        } else {
            throw new BookException(BookException.ERR_BOOK_ID_MUST_BE_NULL_OR_0_EXCEPTION);
        }
    }

    public void deleteBook(Long bookId) {
        repository.deleteById(bookId);
    }

    private void isBookExisting(Long bookId) {
        if (!repository.existsById(bookId)) {
            throw new BookException(BookException.ERR_BOOK_NOT_EXIST_EXCEPTION);
        }
    }

}
