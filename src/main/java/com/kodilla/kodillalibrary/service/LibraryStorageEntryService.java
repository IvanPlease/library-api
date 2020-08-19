package com.kodilla.kodillalibrary.service;

import com.kodilla.kodillalibrary.domain.storage.LibraryStorageEntry;
import com.kodilla.kodillalibrary.domain.storage.LibraryStorageEntryBookDto;
import com.kodilla.kodillalibrary.domain.storage.LibraryStorageEntryDto;
import com.kodilla.kodillalibrary.exception.EntryException;
import com.kodilla.kodillalibrary.mapper.StorageEntryMapper;
import com.kodilla.kodillalibrary.service.repository.LibraryStorageEntryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@Slf4j
@RequiredArgsConstructor
public class LibraryStorageEntryService {
    private final LibraryStorageEntryRepository repository;
    private final StorageEntryMapper mapper;

    public List<LibraryStorageEntryDto> getAllEntries() {
        return mapper.mapEntryToLibraryStorageEntryDtoList(repository.findAll());
    }

    public List<LibraryStorageEntryDto> getAllEntriesById(Long bookId) {
        return mapper.mapEntryToLibraryStorageEntryDtoList(repository.findAllByBook_Id(bookId));
    }

    public LibraryStorageEntryDto getEntryByBook_BookId(Long bookId) {
        return mapper.mapToLibraryStorageEntryDto(repository.findByBook_Id(bookId).get(0));
    }

    public LibraryStorageEntryDto getEntryById(Long entryId) {
        LibraryStorageEntry fetchEntry = repository.findById(entryId).orElseThrow(() -> new EntryException(EntryException.ERR_ENTRY_NOT_FOUND));
        return mapper.mapToLibraryStorageEntryDto(fetchEntry);
    }

    public LibraryStorageEntryDto updateEntry(LibraryStorageEntryDto storageEntryDto) {
        if (storageEntryDto.getId() != null) {
            isEntryExisting(storageEntryDto.getId());
        } else {
            throw new EntryException(EntryException.ERR_ENTRY_ID_MUST_BE_NOT_NULL_EXCEPTION);
        }
        LibraryStorageEntry updatedEntry = repository.save(mapper.mapToLibraryStorageEntry(storageEntryDto));
        return mapper.mapToLibraryStorageEntryDto(updatedEntry);
    }

    public LibraryStorageEntryDto createEntry(LibraryStorageEntryDto storageEntryDto) {
        if (storageEntryDto.getId() == null || storageEntryDto.getId() == 0L) {
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
