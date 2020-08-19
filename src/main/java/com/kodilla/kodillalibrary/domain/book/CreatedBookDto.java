package com.kodilla.kodillalibrary.domain.book;

import com.kodilla.kodillalibrary.domain.storage.LibraryStorageEntryBookDto;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatedBookDto {
    private Long id;
    private String title;
    private String author;
    private int pubYear;
    private List<LibraryStorageEntryBookDto> copyList;
}
