package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.reader.ReaderDto;
import com.kodilla.kodillalibrary.facade.ReaderFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/readers")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderFacade facade;

    @GetMapping
    public List<ReaderDto> getReaders() {
        return facade.fetchAllReaders();
    }

    @GetMapping(value = "/{readerId}")
    public ReaderDto getReader(@PathVariable Long readerId) {
        return facade.fetchReaderById(readerId);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ReaderDto updateReader(@RequestBody ReaderDto readerDto) {
        return facade.updateReader(readerDto);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ReaderDto createReader(@RequestBody ReaderDto readerDto) {
        return facade.createReader(readerDto);
    }

    @DeleteMapping(value = "/{readerId}")
    public void deleteReader(@PathVariable Long readerId) {
        facade.deleteReader(readerId);
    }
}
