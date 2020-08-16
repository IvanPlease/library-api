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
public class BookDto {
    private long bookId;
    private String bookTitle;
    private String bookAuthor;
    private int pubYear;
    private List<LibraryStorageEntryDto> copyList;
}
