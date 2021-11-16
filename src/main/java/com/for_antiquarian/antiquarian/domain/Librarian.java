package com.for_antiquarian.antiquarian.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LIBRARIAN")
public class Librarian {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    @NotNull
    private Long id;

    @Column(name = "LIB_NAME")
    @NotNull
    private String libName;

    @Column(name = "LIB_SURNAME")
    @NotNull
    private String libSurname;

    @Column(name = "LIB_EMAIL")
    @NotNull
    private String libEmail;

    @Column(name = "LIB_ADDRESS")
    @NotNull
    private String libAddress;

    @Column(name = "LIB_PHONE_NUMBER")
    @NotNull
    private int libPhoneNumber;

    @Column(name = "WORKER_FROM")
    @NotNull
    private LocalDate workerFrom;

    @Column(name = "WORKER_TO")
    private LocalDate workerTo;
}
