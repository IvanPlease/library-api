package com.kodilla.kodillalibrary.domain;

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
    private Long entryId;
    private BookDto book;
    private Long copyId;
    private Long status;
    private List<RentDto> rentList;
}
