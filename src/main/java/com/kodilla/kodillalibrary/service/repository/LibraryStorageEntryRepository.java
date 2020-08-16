package com.kodilla.kodillalibrary.service.repository;

import com.kodilla.kodillalibrary.domain.LibraryStorageEntry;
import org.springframework.data.repository.CrudRepository;

public interface LibraryStorageEntryRepository extends CrudRepository<LibraryStorageEntry, Long> {
}
