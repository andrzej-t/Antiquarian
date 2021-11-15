package com.for_antiquarian.antiquarian.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reader {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    @NotNull
    private Long id;

    @Column(name = "readerName")
    @NotNull
    private String readerName;

    @Column(name = "accountFrom")
    @NotNull
    private LocalDate accountFrom;

    @Column(name = "accountTo")
    @NotNull
    private LocalDate accountTo;

    @Column(name = "readerSurname")
    @NotNull
    private String readerSurname;

    @Column(name = "readerEmail")
    @NotNull
    private String readerEmail;

    @Column(name = "readerAddress")
    @NotNull
    private String readerAddress;

    @Column(name = "readerPhoneNumber")
    @NotNull
    private int readerPhoneNumber;

    @Column(name = "readerStatus")
    @NotNull
    private ReaderStatus readerStatus;

}
