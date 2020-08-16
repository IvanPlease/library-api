package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class BookController {
    @GetMapping
    public List<BookDto> getBooks(){
        return new ArrayList<>();
    }
    @GetMapping(value = "/{bookId}")
    public List<BookDto> getBook(@PathVariable Long bookId){
        return new ArrayList<>();
    }
    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public BookDto updateBook(@RequestBody BookDto bookDto){
        return BookDto.builder().build();
    }
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public BookDto createBook(@RequestBody BookDto bookDto){
        return BookDto.builder().build();
    }
    @DeleteMapping(value = "/{bookId}")
    public void deleteBook(@PathVariable Long bookId){
    }
}
