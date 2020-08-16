package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.service.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }
}
