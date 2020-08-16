package com.kodilla.kodillalibrary.controller;

import com.kodilla.kodillalibrary.domain.LibraryStorageEntryDto;
import com.kodilla.kodillalibrary.facade.LibraryStorageEntryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/copies")
@RequiredArgsConstructor
public class LibraryStorageEntryController {

    private final LibraryStorageEntryFacade facade;

    @GetMapping
    public List<LibraryStorageEntryDto> getCopies() {
        return facade.fetchAllEntries();
    }

    @GetMapping(value = "/{entryId}")
    public LibraryStorageEntryDto getCopy(@PathVariable Long entryId) {
        return facade.fetchEntryById(entryId);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public LibraryStorageEntryDto updateCopy(@RequestBody LibraryStorageEntryDto libraryStorageEntryDto) {
        return facade.updateEntry(libraryStorageEntryDto);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public LibraryStorageEntryDto createCopy(@RequestBody LibraryStorageEntryDto libraryStorageEntryDto) {
        return facade.createEntry(libraryStorageEntryDto);
    }

    @DeleteMapping(value = "/{entryId}")
    public void deleteCopy(@PathVariable Long entryId) {
        facade.deleteEntry(entryId);
    }

    @PutMapping(value = "/{entryId}/{status}")
    public LibraryStorageEntryDto changeStatus(@PathVariable Long entryId, @PathVariable Long status){
        return facade.changeStatus(entryId, status);
    }

    @GetMapping(value = "/{bookId}/count")
    public int getCopyCount(@PathVariable Long bookId){
        return facade.getCopyCount(bookId);
    }

    @GetMapping(value = "/{bookId}/addCopy")
    public LibraryStorageEntryDto addCopyOfBook(@PathVariable Long bookId){
        return facade.addCopy(bookId);
    }

}
