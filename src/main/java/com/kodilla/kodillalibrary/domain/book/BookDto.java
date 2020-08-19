package com.kodilla.kodillalibrary.domain.book;

import com.kodilla.kodillalibrary.domain.storage.LibraryStorageEntryDto;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private int pubYear;
    private List<LibraryStorageEntryDto> copyList;
}
