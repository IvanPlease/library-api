package com.kodilla.kodillalibrary.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Readers")
public class Reader {
    @NotNull
    @Id
    @GeneratedValue
    private Long readerId;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    private Date creationDate;
    @NotNull
    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "reader",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Rent> rentList;
    private boolean blackListed;
}
