package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.service.repository.ReaderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReaderService {
    private final ReaderRepository repository;

    public ReaderService(ReaderRepository repository) {
        this.repository = repository;
    }
}
