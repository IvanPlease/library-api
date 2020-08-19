package com.kodilla.kodillalibrary.domain.reader;

import com.kodilla.kodillalibrary.domain.rent.Rent;
import com.sun.istack.NotNull;
import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import java.beans.ConstructorProperties;
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
    private Long id;
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
