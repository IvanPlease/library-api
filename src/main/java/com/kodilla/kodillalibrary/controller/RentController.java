package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.RentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/rents")
@RequiredArgsConstructor
public class RentController {
    @GetMapping
    public List<RentDto> getRents(){
        return new ArrayList<>();
    }
    @GetMapping(value = "/{rentId}")
    public List<RentDto> getRent(@PathVariable Long rentId){
        return new ArrayList<>();
    }
    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public RentDto updateRent(@RequestBody RentDto rentDto){
        return RentDto.builder().build();
    }
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public RentDto createRent(@RequestBody RentDto rentDto){
        return RentDto.builder().build();
    }
    @DeleteMapping(value = "/{rentId}")
    public void deleteRent(@PathVariable Long rentId){
    }
}
