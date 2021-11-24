package com.for_antiquarian.antiquarian.mapper;

import com.for_antiquarian.antiquarian.domain.Reader;
import com.for_antiquarian.antiquarian.domain.ReaderDto;
import com.for_antiquarian.antiquarian.domain.ReaderStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ReaderMapperTestSuite {

    @Autowired
    ReaderMapper readerMapper;

    @Test
    public void testMapToReader() {
        //Given
        ReaderDto readerDto = new ReaderDto(1L, "Name1", "Surname1", LocalDate.of(2021, 9, 1), LocalDate.now(), "email1", "address1", 123456789, ReaderStatus.ACTIVE);

        //When
        Reader result = readerMapper.mapToReader(readerDto);

        //Then
        assertEquals(1L, result.getId());
        assertEquals("Name1", result.getReaderName());
        assertEquals("Surname1", result.getReaderSurname());
        assertEquals(LocalDate.of(2021, 9, 1), result.getAccountFrom());
        assertEquals(LocalDate.now(), result.getAccountTo());
        assertEquals("email1", result.getReaderEmail());
        assertEquals("address1", result.getReaderAddress());
        assertEquals(123456789, result.getReaderPhoneNumber());
        assertEquals(ReaderStatus.ACTIVE, result.getReaderStatus());
    }

    @Test
    public void testMapToReaderDto() {
        //Given
        Reader reader = new Reader(1L, "Name1", "Surname1", LocalDate.of(2021, 9, 1), LocalDate.now(), "email1", "address1", 123456789, ReaderStatus.ACTIVE);

        //When
        ReaderDto result = readerMapper.mapToReaderDto(reader);

        //Then
        assertEquals(1L, result.getId());
        assertEquals("Name1", result.getReaderName());
        assertEquals("Surname1", result.getReaderSurname());
        assertEquals(LocalDate.of(2021, 9, 1), result.getAccountFrom());
        assertEquals(LocalDate.now(), result.getAccountTo());
        assertEquals("email1", result.getReaderEmail());
        assertEquals("address1", result.getReaderAddress());
        assertEquals(123456789, result.getReaderPhoneNumber());
        assertEquals(ReaderStatus.ACTIVE, result.getReaderStatus());
    }

    @Test
    public void testMapToReaderDtoList() {
        //Given
        List<Reader> readerList = new ArrayList<>();
        readerList.add(new Reader(1L, "Name1", "Surname1", LocalDate.of(2021, 9, 1), LocalDate.now(), "email1", "address1", 123456789, ReaderStatus.ACTIVE));

        //When
        List<ReaderDto> result = readerMapper.mapToReaderDtoList(readerList);

        //Then
        assertEquals(1L, result.get(0).getId());
        assertEquals("Name1", result.get(0).getReaderName());
        assertEquals("Surname1", result.get(0).getReaderSurname());
        assertEquals(LocalDate.of(2021, 9, 1), result.get(0).getAccountFrom());
        assertEquals(LocalDate.now(), result.get(0).getAccountTo());
        assertEquals("email1", result.get(0).getReaderEmail());
        assertEquals("address1", result.get(0).getReaderAddress());
        assertEquals(123456789, result.get(0).getReaderPhoneNumber());
        assertEquals(ReaderStatus.ACTIVE, result.get(0).getReaderStatus());
    }

}

