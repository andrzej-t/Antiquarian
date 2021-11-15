package com.for_antiquarian.antiquarian.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    @NotNull
    private Long id;
    private String title;
}
