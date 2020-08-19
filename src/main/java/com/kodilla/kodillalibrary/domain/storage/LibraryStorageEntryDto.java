package com.kodilla.kodillalibrary.domain.storage;

import com.kodilla.kodillalibrary.domain.book.StorageBookDto;
import com.kodilla.kodillalibrary.domain.rent.FetchedRentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibraryStorageEntryDto {
    private Long id;
    private StorageBookDto book;
    private Long copyId;
    private Long status;
    private List<FetchedRentDto> rentList;
}
