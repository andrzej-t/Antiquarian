package com.for_antiquarian.antiquarian.domain;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Component
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

    @Column(name = "AUTHOR")
    @NotNull
    private String author;

    @Column(name = "SIGNATURE", unique = true)
    @NotNull
    private String signature;

    @Column(name = "BOOK_STATUS")
    @NotNull
    private BookStatus bookStatus;

    @OneToMany(
            mappedBy = "book"
    )
    private List<Borrowing> borrowingList;

    public Book(Long id, String title, String author, String signature, BookStatus bookStatus) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.signature = signature;
        this.bookStatus = bookStatus;
    }
}
