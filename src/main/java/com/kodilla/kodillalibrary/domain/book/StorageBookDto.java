package com.kodilla.kodillalibrary.domain.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StorageBookDto {
    private Long id;
    private String title;
    private String author;
    private int pubYear;
}
