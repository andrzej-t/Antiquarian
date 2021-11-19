package com.for_antiquarian.antiquarian.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BorrowingDto {

    private Long id;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private Book book;
    private Reader reader;
}
