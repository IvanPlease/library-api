package com.kodilla.kodillalibrary.domain;

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
    private Long readerId;
    private String firstname;
    private String lastname;
    private Date creationDate;
    private List<RentDto> rentList;
    private boolean blackListed;
}
