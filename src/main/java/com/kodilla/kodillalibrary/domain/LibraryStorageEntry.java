package com.kodilla.kodillalibrary.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "LibraryStorage")
public class LibraryStorageEntry {
    @NotNull
    @Id
    @GeneratedValue
    private Long entryId;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "bookId")
    private Book book;
    @NotNull
    private Long copyId;
    @NotNull
    private Long status;
    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "storageEntry",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Rent> rentList;
}
