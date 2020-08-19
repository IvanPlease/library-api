package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.storage.LibraryStorageEntry;
import com.kodilla.kodillalibrary.domain.storage.LibraryStorageEntryBookDto;
import com.kodilla.kodillalibrary.domain.storage.LibraryStorageEntryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RentMapper.class, BookMapper.class})
public interface StorageEntryMapper {
    @Mapping(target = "rentList", expression = "java(rentMapper.mapFetchedRentDtoListToRentList(storageEntryDto.getRentList()))")
    LibraryStorageEntry mapToLibraryStorageEntry(LibraryStorageEntryDto storageEntryDto);

    LibraryStorageEntryDto mapToLibraryStorageEntryDto(LibraryStorageEntry storageEntryDto);

    @Mapping(target = "book", ignore = true)
    LibraryStorageEntryDto mapToLibraryStorageEntryDto(LibraryStorageEntryBookDto storageEntryDto);

    LibraryStorageEntryBookDto mapToLibraryStorageEntryBookDto(LibraryStorageEntry libraryStorageEntry);

    LibraryStorageEntryBookDto mapToLibraryStorageEntryBookDto(LibraryStorageEntryDto libraryStorageEntry);

    List<LibraryStorageEntry> mapEntryDtoToLibraryStorageEntryList(List<LibraryStorageEntryDto> storageEntryList);

    List<LibraryStorageEntryDto> mapEntryToLibraryStorageEntryDtoList(List<LibraryStorageEntry> storageEntryList);

    List<LibraryStorageEntryDto> mapEntryToBookDtoLibraryStorageEntryDtoList(List<LibraryStorageEntryBookDto> storageEntryList);

    List<LibraryStorageEntryBookDto> mapEntryToLibraryStorageEntryBookDtoList(List<LibraryStorageEntry> storageEntryList);

    List<LibraryStorageEntryBookDto> mapEntryDtoToLibraryStorageEntryBookDtoList(List<LibraryStorageEntryDto> storageEntryList);
}
