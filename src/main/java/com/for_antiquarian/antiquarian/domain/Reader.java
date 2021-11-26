package com.for_antiquarian.antiquarian.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "READER")
public class Reader {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    @NotNull
    private Long id;

    @Column(name = "READER_NAME")
    @NotNull
    private String readerName;

    @Column(name = "READER_SURNAME")
    @NotNull
    private String readerSurname;

    @Column(name = "ACCOUNT_FROM")
    @NotNull
    private LocalDate accountFrom;

    @Column(name = "ACCOUNT_TO")
    private LocalDate accountTo;

    @Column(name = "READER_EMAIL")
    @NotNull
    private String readerEmail;

    @Column(name = "READER_ADDRESS")
    @NotNull
    private String readerAddress;

    @Column(name = "READER_PHONE_NUMBER")
    @NotNull
    private int readerPhoneNumber;

    @Column(name = "READER_STATUS")
    @NotNull
    private Status status;

    @OneToMany(mappedBy = "reader")
    private List<Borrowing> borrowingList;

    public Reader(Long id, String readerName, String readerSurname, LocalDate accountFrom, LocalDate accountTo, String readerEmail, String readerAddress, int readerPhoneNumber, Status status) {
        this.id = id;
        this.readerName = readerName;
        this.readerSurname = readerSurname;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.readerEmail = readerEmail;
        this.readerAddress = readerAddress;
        this.readerPhoneNumber = readerPhoneNumber;
        this.status = status;
    }
}

