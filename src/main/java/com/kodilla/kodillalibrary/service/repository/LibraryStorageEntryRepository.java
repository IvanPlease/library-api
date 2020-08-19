package com.kodilla.kodillalibrary.service.repository;

import com.kodilla.kodillalibrary.domain.storage.LibraryStorageEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryStorageEntryRepository extends CrudRepository<LibraryStorageEntry, Long> {
    @Override
    List<LibraryStorageEntry> findAll();

    List<LibraryStorageEntry> findAllByBook_Id(Long bookId);

    List<LibraryStorageEntry> findByBook_Id(Long bookId);
}
