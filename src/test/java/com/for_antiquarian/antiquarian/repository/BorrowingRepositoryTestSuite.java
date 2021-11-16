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

    @Test
    public void testBorrowingRepositorySave() {

        //Given
        Book book = new Book(44l, "Title2", "Author1", "signature1", BookStatus.AVAILABLE);
        Reader reader = new Reader(33L, "Name", "Surname",  LocalDate.of(2021,9,12), LocalDate.of(2021,10,11), "email", "address", 123456789, ReaderStatus.ACTIVE);
        Borrowing borrowing = new Borrowing(null, LocalDate.of(2021,9,12), LocalDate.of(2021,10,11), book, reader);

        //When
        borrowingRepository.save(borrowing);

        //Then
        Long id = borrowing.getId();
        Optional<Borrowing> findBorrowing = borrowingRepository.findById(id);
        assertTrue(findBorrowing.isPresent());

        //CleanUp
        borrowingRepository.deleteById(id);
    }

//    @Test
//    public void testBorrowingRepositoryDeleteAll() {
//
//        //When
//        borrowingRepository.deleteAll();
//
//    }
}
