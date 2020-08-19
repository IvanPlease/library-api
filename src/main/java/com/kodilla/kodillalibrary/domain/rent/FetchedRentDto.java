package com.kodilla.kodillalibrary.domain.rent;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FetchedRentDto {
    private Long id;
    private Long entryId;
    private Long readerId;
    private Date rentDate;
    private Date returnDate;
}
