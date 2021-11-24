package com.for_antiquarian.antiquarian.mapper;

import com.for_antiquarian.antiquarian.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BorrowingMapperTestSuite {

    @Autowired
    BorrowingMapper borrowingMapper;

    @Test
    public void testMapToBorrowing() {
        //Given
        Book book1 = new Book(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE);
        Reader reader1 = new Reader(2L, "Name1", "Surname1", LocalDate.of(2021, 9, 1), null, "email1", "address1", 123456789, ReaderStatus.ACTIVE);
        BorrowingDto borrowingDto = new BorrowingDto(3L, LocalDate.of(2021, 12, 12), LocalDate.of(2021, 12, 19), book1, reader1);

        //When
        Borrowing result = borrowingMapper.mapToBorrowing(borrowingDto);

        //Then
        assertEquals(3L, result.getId());
        assertEquals(LocalDate.of(2021, 12, 12), result.getBorrowDate());
        assertEquals(LocalDate.of(2021, 12, 19), result.getReturnDate());
        assertEquals(book1, result.getBook());
        assertEquals(reader1, result.getReader());
    }

    @Test
    public void testMapToBorrowingDto() {
        //Given
        Book book1 = new Book(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE);
        Reader reader1 = new Reader(2L, "Name1", "Surname1", LocalDate.of(2021, 9, 1), null, "email1", "address1", 123456789, ReaderStatus.ACTIVE);
        Borrowing borrowing = new Borrowing(3L, LocalDate.of(2021, 12, 12), LocalDate.of(2021, 12, 19), book1, reader1);

        //When
        BorrowingDto result = borrowingMapper.mapToBorrowingDto(borrowing);

        //Then
        assertEquals(3L, result.getId());
        assertEquals(LocalDate.of(2021, 12, 12), result.getBorrowDate());
        assertEquals(LocalDate.of(2021, 12, 19), result.getReturnDate());
        assertEquals(book1, result.getBook());
        assertEquals(reader1, result.getReader());
    }

    @Test
    public void testMapToBorrowingDtoList() {
        //Given
        List<Borrowing> borrowingList = new ArrayList<>();

        Book book1 = new Book(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE);
        Reader reader1 = new Reader(2L, "Name1", "Surname1", LocalDate.of(2021, 9, 1), null, "email1", "address1", 123456789, ReaderStatus.ACTIVE);

        borrowingList.add(new Borrowing(3L, LocalDate.of(2021, 12, 12), LocalDate.of(2021, 12, 19), book1, reader1));

        //When
        List<BorrowingDto> result = borrowingMapper.mapToBorrowingDtoList(borrowingList);

        //Then
        assertEquals(3L, result.get(0).getId());
        assertEquals(LocalDate.of(2021, 12, 12), result.get(0).getBorrowDate());
        assertEquals(LocalDate.of(2021, 12, 19), result.get(0).getReturnDate());
        assertEquals(book1, result.get(0).getBook());
        assertEquals(reader1, result.get(0).getReader());
    }

}

