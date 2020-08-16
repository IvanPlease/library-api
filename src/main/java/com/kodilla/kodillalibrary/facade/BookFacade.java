package com.kodilla.kodillalibrary.facade;

import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.domain.LibraryStorageEntry;
import com.kodilla.kodillalibrary.service.BookService;
import com.kodilla.kodillalibrary.service.LibraryStorageEntryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class BookFacade {

    private final BookService service;
    private final LibraryStorageEntryService entryService;

    public List<BookDto> fetchAllBooks() {
        return service.getAllBooks();
    }

    public BookDto fetchBookById(Long bookId) {
        return service.getBookById(bookId);
    }

    public BookDto updateBook(BookDto bookDto) {
        return service.updateBook(bookDto);
    }

    public BookDto createBook(BookDto bookDto) {
        return service.createBook(bookDto);
    }

    public void deleteBook(Long bookId) {
        service.deleteBook(bookId);
    }

}
