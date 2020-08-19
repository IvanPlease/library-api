package com.kodilla.kodillalibrary.domain.reader;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReaderRentDto {
    private Long id;
    private String firstname;
    private String lastname;
    private Date creationDate;
    private boolean blackListed;
}
