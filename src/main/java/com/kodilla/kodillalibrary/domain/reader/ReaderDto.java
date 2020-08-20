package com.kodilla.kodillalibrary.domain.reader;

import com.kodilla.kodillalibrary.domain.rent.FetchedRentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private boolean blacklisted;
}
