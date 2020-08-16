package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.ReaderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/readers")
@RequiredArgsConstructor
public class ReaderController {
    @GetMapping
    public List<ReaderDto> getReaders(){
        return new ArrayList<>();
    }
    @GetMapping(value = "/{readerId}")
    public List<ReaderDto> getReader(@PathVariable Long readerId){
        return new ArrayList<>();
    }
    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ReaderDto updateReader(@RequestBody ReaderDto readerDto){
        return ReaderDto.builder().build();
    }
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ReaderDto createReader(@RequestBody ReaderDto readerDto){
        return ReaderDto.builder().build();
    }
    @DeleteMapping(value = "/{readerId}")
    public void deleteReader(@PathVariable Long readerId){
    }
}
