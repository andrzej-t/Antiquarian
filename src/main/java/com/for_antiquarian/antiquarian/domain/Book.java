package com.for_antiquarian.antiquarian.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    @NotNull
    private Long id;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "signature", unique = true)
    @NotNull
    private String signature;

    @Column(name = "bookStatus")
    @NotNull
    private BookStatus bookStatus;
}
