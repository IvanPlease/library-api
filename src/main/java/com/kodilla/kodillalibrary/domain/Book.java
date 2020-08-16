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
@Entity(name = "Books")
@Table
@Builder
public class Book {
    @NotNull
    @Id
    @GeneratedValue
    private long bookId;
    @NotNull
    private String bookTitle;
    @NotNull
    private String bookAuthor;
    @NotNull
    private int pubYear;
    @NotNull
    @OneToMany(mappedBy = "book")
    private List<LibraryStorageEntry> copyList;
}
