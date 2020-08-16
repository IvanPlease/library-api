package com.kodilla.kodillalibrary.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "Readers")
public class Reader {
    @NotNull
    @Id
    @GeneratedValue
    private long readerId;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private Date creationDate;
    @NotNull
    @OneToMany(mappedBy = "reader")
    private List<Rent> rentList;
}
