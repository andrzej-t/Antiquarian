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

        //Given
        Reader reader = new Reader(null, "Name", "Surname",  LocalDate.of(2021,9,12), LocalDate.of(2021,10,11), "email", "address", 123456789, ReaderStatus.ACTIVE);

        //When
        readerRepository.save(reader);

        //Then
        Long id = reader.getId();
        Optional<Reader> findReader = readerRepository.findById(id);
        assertTrue(findReader.isPresent());

        //CleanUp
        readerRepository.deleteById(id);
    }

//    @Test
//    public void testBorrowingRepositoryDeleteAll() {
//
//        //When
//        readerRepository.deleteAll();
//
//    }

}
