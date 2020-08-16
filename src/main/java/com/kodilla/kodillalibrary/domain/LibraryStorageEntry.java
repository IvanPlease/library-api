package com.kodilla.kodillalibrary.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "LibraryStorage")
public class LibraryStorageEntry {
    @NotNull
    @Id
    @GeneratedValue
    private long entryId;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "bookId")
    private Book book;
    @NotNull
    private long copyId;
    @NotNull
    private boolean status;
    @NotNull
    @OneToMany(mappedBy = "storageEntry")
    private List<Rent> rentList;
}
