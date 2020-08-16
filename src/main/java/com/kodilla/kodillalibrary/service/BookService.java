package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.service.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;
}
