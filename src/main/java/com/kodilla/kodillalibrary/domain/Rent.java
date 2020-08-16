package com.kodilla.kodillalibrary.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Rents")
public class Rent {
    @NotNull
    @Id
    @GeneratedValue
    private long rentId;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "copyId")
    private LibraryStorageEntry storageEntry;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "readerId")
    private Reader reader;
    @NotNull
    private Date rentDate;
    private Date returnDate;
}
