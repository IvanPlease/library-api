package com.kodilla.kodillalibrary.facade;

import com.kodilla.kodillalibrary.domain.book.BookDto;
import com.kodilla.kodillalibrary.domain.book.CreatedBookDto;
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

    public List<BookDto> fetchAllBooks() {
        return service.getAllBooks();
    }

    public CreatedBookDto fetchBookById(Long bookId) {
        return service.getBookById(bookId);
    }

    public BookDto updateBook(BookDto bookDto) {
        return service.updateBook(bookDto);
    }

    public CreatedBookDto createBook(CreatedBookDto bookDto) {
        return service.createBook(bookDto);
    }

    public void deleteBook(Long bookId) {
        service.deleteBook(bookId);
    }

}
