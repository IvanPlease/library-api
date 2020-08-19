package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.book.Book;
import com.kodilla.kodillalibrary.domain.book.BookDto;
import com.kodilla.kodillalibrary.domain.book.CreatedBookDto;
import com.kodilla.kodillalibrary.domain.storage.LibraryStorageEntry;
import com.kodilla.kodillalibrary.exception.BookException;
import com.kodilla.kodillalibrary.mapper.BookMapper;
import com.kodilla.kodillalibrary.service.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;
    private final BookMapper mapper;

    public List<BookDto> getAllBooks() {
        return mapper.mapToBookDtoList(repository.findAll());
    }

    public CreatedBookDto getBookById(Long bookId) {
        Book fetchedBook = repository.findById(bookId).orElseThrow(() -> new BookException(BookException.ERR_BOOK_NOT_FOUND_EXCEPTION));
        return mapper.mapToCreatedBookDto(fetchedBook);
    }

    public BookDto updateBook(BookDto bookDto) {
        if (bookDto.getId() != null) {
            isBookExisting(bookDto.getId());
        } else {
            throw new BookException(BookException.ERR_BOOK_ID_MUST_BE_NOT_NULL_EXCEPTION);
        }
        Book updatedBook = repository.save(mapper.mapToBook(bookDto));
        return mapper.mapToBookDto(updatedBook);
    }

    public CreatedBookDto createBook(CreatedBookDto createdBookDto) {
        Book book = mapper.mapToBook(createdBookDto);
        LibraryStorageEntry storageEntry = LibraryStorageEntry.builder()
                .copyId(1L)
                .book(book)
                .status(0L)
                .rentList(new ArrayList<>())
                .build();
        book.getCopyList().add(storageEntry);
        Book createdBook = repository.save(book);
        return mapper.mapToCreatedBookDto(createdBook);
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
