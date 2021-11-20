package com.for_antiquarian.antiquarian.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@org.hibernate.annotations.NamedQuery(
        name = "Borrowing.setReturnDate",
        query = "update Borrowing set returnDate = :DATE where book.id = :FETCHED_ID and returnDate = null"
)

@org.hibernate.annotations.NamedQuery(
        name = "Borrowing.setBorrowDate",
        query = "update Borrowing set borrowDate = :DATE where book.id = :FETCHED_ID and borrowDate = null"
)

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BORROWING")
@Component
public class Borrowing {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    @NotNull
    private Long id;

    @Column(name = "BORROW_DATE")
    private LocalDate borrowDate;

    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;

    @ManyToOne
    @JsonBackReference
    private Book book;

    @ManyToOne
    @JsonBackReference
    private Reader reader;

}
