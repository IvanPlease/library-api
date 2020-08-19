package com.kodilla.kodillalibrary.domain.reader;

import com.kodilla.kodillalibrary.domain.rent.FetchedRentDto;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReaderDto {
    private Long id;
    private String firstname;
    private String lastname;
    private Date creationDate;
    private List<FetchedRentDto> rentList;
    private boolean blackListed;
}
