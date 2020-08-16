package com.kodilla.kodillalibrary.service.repository;

import com.kodilla.kodillalibrary.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
