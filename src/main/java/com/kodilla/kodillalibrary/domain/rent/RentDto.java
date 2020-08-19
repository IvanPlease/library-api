package com.kodilla.kodillalibrary.domain.rent;

import com.kodilla.kodillalibrary.domain.storage.LibraryStorageEntryDto;
import com.kodilla.kodillalibrary.domain.reader.ReaderRentDto;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentDto {
    private Long id;
    private LibraryStorageEntryDto storageEntry;
    private ReaderRentDto reader;
    private Date rentDate;
    private Date returnDate;
}
