package com.kodilla.kodillalibrary.service.repository;

import com.kodilla.kodillalibrary.domain.Rent;
import org.springframework.data.repository.CrudRepository;

public interface RentRepository extends CrudRepository<Rent, Long> {
}
