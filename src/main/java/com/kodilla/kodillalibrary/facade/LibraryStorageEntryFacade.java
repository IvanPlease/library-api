package com.kodilla.kodillalibrary.facade;

import com.kodilla.kodillalibrary.domain.book.BookDto;
import com.kodilla.kodillalibrary.domain.book.CreatedBookDto;
import com.kodilla.kodillalibrary.domain.storage.LibraryStorageEntryBookDto;
import com.kodilla.kodillalibrary.domain.storage.LibraryStorageEntryDto;
import com.kodilla.kodillalibrary.service.BookService;
import com.kodilla.kodillalibrary.service.LibraryStorageEntryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class LibraryStorageEntryFacade {

    private final LibraryStorageEntryService service;
    private final BookService bookService;

    public List<LibraryStorageEntryDto> fetchAllEntries() {
        return service.getAllEntries();
    }

    public LibraryStorageEntryDto fetchEntryById(Long entryId) {
        return service.getEntryById(entryId);
    }

    public LibraryStorageEntryDto updateEntry(LibraryStorageEntryDto libraryStorageEntryDto) {
        return service.updateEntry(libraryStorageEntryDto);
    }

    public LibraryStorageEntryDto createEntry(LibraryStorageEntryDto libraryStorageEntryDto) {
        return service.createEntry(libraryStorageEntryDto);
    }

    public LibraryStorageEntryDto changeStatus(Long entryId, Long status) {
        return service.changeStatus(entryId, status);
    }

    public int getCopyCount(Long bookId) {
        List<LibraryStorageEntryDto> entryDtoList = service.getAllEntriesById(bookId);
        return entryDtoList.size();
    }

    public LibraryStorageEntryDto addCopy(Long bookId) {
        CreatedBookDto bookDto = bookService.getBookById(bookId);
        LibraryStorageEntryDto entry = service.getEntryByBook_BookId(bookDto.getId());
        entry.setId(null);
        entry.setCopyId((long) (bookDto.getCopyList().size() + 1));
        return service.createEntry(entry);
    }

    public void deleteEntry(Long entryId) {
        service.deleteEntry(entryId);
    }
}
