package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.rent.RentDto;
import com.kodilla.kodillalibrary.facade.RentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/rents")
@RequiredArgsConstructor
public class RentController {

    private final RentFacade facade;

    @GetMapping
    public List<RentDto> getRents() {
        return facade.fetchAllRents();
    }

    @GetMapping(value = "/{rentId}")
    public RentDto getRent(@PathVariable Long rentId) {
        return facade.fetchRentById(rentId);
    }

    @PutMapping(value = "/{status}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public RentDto updateRent(@RequestBody RentDto rentDto, @PathVariable boolean status) {
        return facade.updateRent(rentDto, status);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public RentDto createRent(@RequestBody RentDto rentDto) {
        return facade.createRent(rentDto);
    }

    @DeleteMapping(value = "/{rentId}")
    public void deleteRent(@PathVariable Long rentId) {
        facade.deleteRent(rentId);
    }

    @PutMapping(value = "/{rentId}/pay")
    public RentDto payForBook(@PathVariable Long rentId) {
        return facade.payForLostBook(rentId);
    }
}
