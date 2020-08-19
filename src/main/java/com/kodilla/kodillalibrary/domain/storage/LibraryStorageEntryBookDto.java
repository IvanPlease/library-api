package com.kodilla.kodillalibrary.domain.storage;

import com.kodilla.kodillalibrary.domain.rent.FetchedRentDto;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibraryStorageEntryBookDto {
    private Long id;
    private Long copyId;
    private Long status;
    private List<FetchedRentDto> rentList;
}
