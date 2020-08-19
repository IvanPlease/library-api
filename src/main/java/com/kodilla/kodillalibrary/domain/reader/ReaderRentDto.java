package com.kodilla.kodillalibrary.domain.reader;

import lombok.*;

import java.util.Date;
import java.util.List;

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
