package com.kodilla.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentDto {
    private Long rentId;
    private LibraryStorageEntryDto storageEntry;
    private ReaderDto reader;
    private Date rentDate;
    private Date returnDate;
}
