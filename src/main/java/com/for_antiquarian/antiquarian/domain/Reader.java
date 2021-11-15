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
    private String readerName;
    private LocalDate accountFrom;
    private LocalDate accountTo;
    private String readerSurname;
    private String readerEmail;
    private String readerAddress;
    private int readerPhoneNumber;
}
