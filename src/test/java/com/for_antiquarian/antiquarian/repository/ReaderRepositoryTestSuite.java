package com.for_antiquarian.antiquarian.repository;

import com.for_antiquarian.antiquarian.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ReaderRepositoryTestSuite {

    @Autowired
    ReaderRepository readerRepository;

    @Test
    public void testReaderRepositorySave() {

//        //Given
//        Reader reader1 = new Reader(null, "Name1", "Surname1",  LocalDate.of(2021,9,1), null, "email1", "address1", 123456789, ReaderStatus.ACTIVE);
////        Reader reader2 = new Reader(null, "Name2", "Surname2",  LocalDate.of(2021,9,2), null, "email2", "address2", 223456789, ReaderStatus.ACTIVE);
//
//        //When
//        readerRepository.save(reader1);
////        readerRepository.save(reader2);
//
//        //Then
//        Long id = reader1.getId();
//        Optional<Reader> findReader = readerRepository.findById(id);
//        assertTrue(findReader.isPresent());
//
//        //CleanUp
//        readerRepository.deleteById(id);
    }

//    @Test
//    public void testBorrowingRepositoryDeleteAll() {
//
//        //When
//        readerRepository.deleteAll();
//
//    }
}

