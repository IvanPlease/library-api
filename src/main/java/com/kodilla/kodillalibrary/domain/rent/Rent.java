package com.kodilla.kodillalibrary.domain.rent;

import com.kodilla.kodillalibrary.domain.reader.Reader;
import com.kodilla.kodillalibrary.domain.storage.LibraryStorageEntry;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Rents")
public class Rent {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "copyId")
    private LibraryStorageEntry storageEntry;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "readerId")
    private Reader reader;
    @Builder.Default
    private Date rentDate = new Date();
    private Date returnDate;
}
