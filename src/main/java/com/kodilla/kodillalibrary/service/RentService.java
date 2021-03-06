package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.rent.Rent;
import com.kodilla.kodillalibrary.domain.rent.RentDto;
import com.kodilla.kodillalibrary.exception.RentException;
import com.kodilla.kodillalibrary.mapper.RentMapper;
import com.kodilla.kodillalibrary.service.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RentService {
    private final RentRepository repository;
    private final RentMapper mapper;

    public List<RentDto> getAllRents() {
        return mapper.mapToRentDtoList(repository.findAll());
    }

    public RentDto getRentById(Long rentId) {
        Rent fetchedRent = repository.findById(rentId).orElseThrow(() -> new RentException(RentException.ERR_RENT_NOT_FOUND_EXCEPTION));
        return mapper.mapToRentDto(fetchedRent);
    }

    public RentDto updateRent(RentDto rentDto) {
        if (rentDto.getId() != null) {
            isRentExisting(rentDto.getId());
        } else {
            throw new RentException(RentException.ERR_RENT_ID_MUST_BE_NOT_NULL_EXCEPTION);
        }
        Date curr = new Date();
        rentDto.setRentDate(curr);
        Rent updatedRent = repository.save(mapper.mapToRent(rentDto));
        return mapper.mapToRentDto(updatedRent);
    }

    public RentDto createRent(RentDto rentDto) {
        if (rentDto.getId() == null || rentDto.getId() == 0L) {
            Rent updatedRent = repository.save(mapper.mapToRent(rentDto));
            return mapper.mapToRentDto(updatedRent);
        } else {
            throw new RentException(RentException.ERR_RENT_ID_MUST_BE_NULL_OR_0_EXCEPTION);
        }
    }

    public void deleteRent(Long bookId) {
        repository.deleteById(bookId);
    }

    private void isRentExisting(Long bookId) {
        if (!repository.existsById(bookId)) {
            throw new RentException(RentException.ERR_RENT_NOT_EXIST_EXCEPTION);
        }
    }
}
