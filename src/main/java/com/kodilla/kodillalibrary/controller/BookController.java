package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.facade.BookFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookFacade facade;

    @GetMapping
    public List<BookDto> getBooks() {
        return facade.fetchAllBooks();
    }

    @GetMapping(value = "/{bookId}")
    public BookDto getBook(@PathVariable Long bookId) {
        return facade.fetchBookById(bookId);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return facade.updateBook(bookDto);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return facade.createBook(bookDto);
    }

    @DeleteMapping(value = "/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        facade.deleteBook(bookId);
    }
}
