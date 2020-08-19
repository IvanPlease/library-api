package com.kodilla.kodillalibrary.service.repository;

import com.kodilla.kodillalibrary.domain.rent.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {
    @Override
    List<Rent> findAll();
}
