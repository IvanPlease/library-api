package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.LibraryStorageEntryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/copies")
@RequiredArgsConstructor
public class LibraryStorageEntryController {
    @GetMapping
    public List<LibraryStorageEntryDto> getCopies(){
        return new ArrayList<>();
    }
    @GetMapping(value = "/{entryId}")
    public List<LibraryStorageEntryDto> getCopy(@PathVariable Long entryId){
        return new ArrayList<>();
    }
    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public LibraryStorageEntryDto updateCopy(@RequestBody LibraryStorageEntryDto libraryStorageEntryDto){
        return LibraryStorageEntryDto.builder().build();
    }
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public LibraryStorageEntryDto createCopy(@RequestBody LibraryStorageEntryDto libraryStorageEntryDto){
        return LibraryStorageEntryDto.builder().build();
    }
    @DeleteMapping(value = "/{entryId}")
    public void deleteCopy(@PathVariable Long entryId){
    }
}
