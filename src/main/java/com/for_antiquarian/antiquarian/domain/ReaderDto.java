package com.for_antiquarian.antiquarian.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ReaderDto {

    private Long id;
    private String readerName;
    private String readerSurname;
    private LocalDate accountFrom;
    private LocalDate accountTo;
    private String readerEmail;
    private String readerAddress;
    private int readerPhoneNumber;
    private ReaderStatus readerStatus;
}

