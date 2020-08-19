package com.kodilla.kodillalibrary.service.repository;

import com.kodilla.kodillalibrary.domain.storage.LibraryStorageEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface LibraryStorageEntryRepository extends CrudRepository<LibraryStorageEntry, Long> {
    @Override
    List<LibraryStorageEntry> findAll();

    List<LibraryStorageEntry> findAllByBook_Id(Long bookId);

    List<LibraryStorageEntry> findByBook_Id(Long bookId);
}
