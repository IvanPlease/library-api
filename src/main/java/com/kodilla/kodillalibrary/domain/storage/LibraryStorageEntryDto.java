package com.kodilla.kodillalibrary.domain.storage;

import com.kodilla.kodillalibrary.domain.book.CreatedBookDto;
import com.kodilla.kodillalibrary.domain.book.StorageBookDto;
import com.kodilla.kodillalibrary.domain.rent.FetchedRentDto;
import lombok.*;

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
