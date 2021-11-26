package com.for_antiquarian.antiquarian.repository;

import com.for_antiquarian.antiquarian.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BorrowingRepositoryTestSuite {

    @Autowired
    BorrowingRepository borrowingRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ReaderRepository readerRepository;

    @Test
    void testBorrowingRepositorySave() {

        //Given
        Book book = new Book(null, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE);
        Reader reader = new Reader(null, "Name1", "Surname1", LocalDate.of(2021, 1, 1), null, "email1", "address1", 123456789, Status.ACTIVE);
        Borrowing borrowing = new Borrowing(null, LocalDate.of(2021, 1, 1), null, book, reader);

        //When
        bookRepository.save(book);
        readerRepository.save(reader);
        borrowingRepository.save(borrowing);

        //Then
        Long id = borrowing.getId();
        Optional<Borrowing> findBorrowing = borrowingRepository.findById(id);
        assertTrue(findBorrowing.isPresent());

        //CleanUp
        borrowingRepository.deleteById(id);
        bookRepository.deleteById(book.getId());
        readerRepository.deleteById(reader.getId());
    }

}

