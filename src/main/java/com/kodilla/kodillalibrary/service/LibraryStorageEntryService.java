package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.LibraryStorageEntry;
import com.kodilla.kodillalibrary.domain.LibraryStorageEntryDto;
import com.kodilla.kodillalibrary.exception.BookException;
import com.kodilla.kodillalibrary.exception.EntryException;
import com.kodilla.kodillalibrary.mapper.BookMapper;
import com.kodilla.kodillalibrary.service.repository.BookRepository;
import com.kodilla.kodillalibrary.service.repository.LibraryStorageEntryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LibraryStorageEntryService {
    private final LibraryStorageEntryRepository repository;
    private final BookMapper mapper;

    public List<LibraryStorageEntryDto> getAllEntries() {
        return mapper.mapToLibraryStorageEntryDtoList(repository.findAll());
    }

    public List<LibraryStorageEntryDto> getAllEntriesById(Long bookId) {
        return mapper.mapToLibraryStorageEntryDtoList(repository.findAllByBook_BookId(bookId));
    }

    public LibraryStorageEntryDto getEntryByBook_BookId(Long bookId) {
        return mapper.mapToLibraryStorageEntryDto(repository.findByBook_BookId(bookId));
    }

    public LibraryStorageEntryDto getEntryById(Long entryId) {
        LibraryStorageEntry fetchEntry = repository.findById(entryId).orElseThrow(() -> new EntryException(EntryException.ERR_ENTRY_NOT_FOUND));
        return mapper.mapToLibraryStorageEntryDto(fetchEntry);
    }

    public LibraryStorageEntryDto updateEntry(LibraryStorageEntryDto storageEntryDto) {
        if (storageEntryDto.getEntryId() != null) {
            isEntryExisting(storageEntryDto.getEntryId());
        } else {
            throw new EntryException(EntryException.ERR_ENTRY_ID_MUST_BE_NOT_NULL_EXCEPTION);
        }
        LibraryStorageEntry updatedEntry = repository.save(mapper.mapToLibraryStorageEntry(storageEntryDto));
        return mapper.mapToLibraryStorageEntryDto(updatedEntry);
    }

    public LibraryStorageEntryDto createEntry(LibraryStorageEntryDto storageEntryDto) {
        if (storageEntryDto.getEntryId() == null || storageEntryDto.getEntryId() == 0L) {
            LibraryStorageEntry updatedEntry = repository.save(mapper.mapToLibraryStorageEntry(storageEntryDto));
            return mapper.mapToLibraryStorageEntryDto(updatedEntry);
        } else {
            throw new EntryException(EntryException.ERR_ENTRY_ID_MUST_BE_NULL_OR_0_EXCEPTION);
        }
    }

    public LibraryStorageEntryDto changeStatus(Long entryId, Long status) {
        if (entryId != null) {
            isEntryExisting(entryId);
        } else {
            throw new EntryException(EntryException.ERR_ENTRY_ID_MUST_BE_NOT_NULL_EXCEPTION);
        }
        LibraryStorageEntry fetchedEntry = repository.findById(entryId).orElseThrow(() -> new EntryException(EntryException.ERR_ENTRY_NOT_FOUND));
        fetchedEntry.setStatus(status);
        LibraryStorageEntry updatedEntry = repository.save(fetchedEntry);
        return mapper.mapToLibraryStorageEntryDto(updatedEntry);
    }

    public void deleteEntry(Long entryId) {
        repository.deleteById(entryId);
    }

    private void isEntryExisting(Long entryId) {
        if (!repository.existsById(entryId)) {
            throw new EntryException(EntryException.ERR_ENTRY_NOT_EXIST_EXCEPTION);
        }
    }
}
