package com.kodilla.kodillalibrary.domain.book;

import com.kodilla.kodillalibrary.domain.storage.LibraryStorageEntry;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Books")
@Table
@Builder
public class Book {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String author;
    @NotNull
    private int pubYear;
    @OneToMany(
            targetEntity = LibraryStorageEntry.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @Builder.Default
    private List<LibraryStorageEntry> copyList = new ArrayList<>();
}
