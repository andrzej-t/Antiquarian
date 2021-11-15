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
public class Librarian {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    @NotNull
    private Long id;

    @Column(name = "libName")
    @NotNull
    private String libName;

    @Column(name = "libSurname")
    @NotNull
    private String libSurname;

    @Column(name = "libEmail")
    @NotNull
    private String libEmail;

    @Column(name = "libAdress")
    @NotNull
    private String libAddress;

    @Column(name = "libPhoneNumber")
    @NotNull
    private int libPhoneNumber;

    @Column(name = "workerFrom")
    @NotNull
    private LocalDate workerFrom;

    @Column(name = "workerTo")
    @NotNull
    private LocalDate workerTo;
}
