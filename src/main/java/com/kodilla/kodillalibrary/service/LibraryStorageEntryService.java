package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.service.repository.LibraryStorageEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LibraryStorageEntryService {
    private final LibraryStorageEntryRepository repository;

    public LibraryStorageEntryService(LibraryStorageEntryRepository repository) {
        this.repository = repository;
    }
}
