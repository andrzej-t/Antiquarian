package com.for_antiquarian.antiquarian.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    @NotNull
    private Long id;

    @Column(name = "TITLE")
    @NotNull
    private String title;

    @Column(name = "AUTHOR_NAME")
    @NotNull
    private String authorName;

    @Column(name = "AUTHOR_SURNAME")
    @NotNull
    private String authorSurname;

    @Column(name = "PUBLICATION_YEAR")
    @NotNull
    private Integer publicationYear;

    @Column(name = "SIGNATURE", unique = true)
    @NotNull
    private String signature;

    @Column(name = "BOOK_STATUS")
    @NotNull
    private BookStatus bookStatus;

    @OneToMany(mappedBy = "book")
    private List<Borrowing> borrowingList;

    public Book(Long id, String title, String authorName, String authorSurname, Integer publicationYear, String signature, BookStatus bookStatus) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.publicationYear = publicationYear;
        this.signature = signature;
        this.bookStatus = bookStatus;
    }

}

