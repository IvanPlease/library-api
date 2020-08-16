package com.kodilla.kodillalibrary.service.repository;

import com.kodilla.kodillalibrary.domain.Book;
import com.kodilla.kodillalibrary.domain.BookDto;
import com.kodilla.kodillalibrary.domain.LibraryStorageEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface LibraryStorageEntryRepository extends CrudRepository<LibraryStorageEntry, Long> {
    @Override
    List<LibraryStorageEntry> findAll();
    List<LibraryStorageEntry> findAllByBook_BookId(Long bookId);
    LibraryStorageEntry findByBook_BookId(Long bookId);
}
