package com.kodilla.kodillalibrary.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibraryStorageEntryDto {
    private long entryId;
    private Book book;
    private long copyId;
    private boolean status;
    private List<RentDto> rentList;
}
