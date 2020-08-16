package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.service.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RentService {
    private final RentRepository repository;
}
