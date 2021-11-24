package com.for_antiquarian.antiquarian.mapper;

import com.for_antiquarian.antiquarian.domain.Book;
import com.for_antiquarian.antiquarian.domain.BookDto;
import com.for_antiquarian.antiquarian.domain.BookStatus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BookMapperTestSuite {

    @Autowired
    BookMapper bookMapper;

    @Test
    public void testMapToBook() {
        //Given
        BookDto bookDto = new BookDto(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE);

        //When
        Book result = bookMapper.mapToBook(bookDto);

        //Then
        assertEquals(1L, result.getId());
        assertEquals("Title1", result.getTitle());
        assertEquals("Name1", result.getAuthorName());
        assertEquals("Surname1", result.getAuthorSurname());
        assertEquals(1991, result.getPublicationYear());
        assertEquals("S1", result.getSignature());
        assertEquals(BookStatus.AVAILABLE, result.getBookStatus());
    }

    @Test
    public void testMapToBookDto() {
        //Given
        Book book = new Book(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE);

        //When
        BookDto result = bookMapper.mapToBookDto(book);

        //Then
        assertEquals(1L, result.getId());
        assertEquals("Title1", result.getTitle());
        assertEquals("Name1", result.getAuthorName());
        assertEquals("Surname1", result.getAuthorSurname());
        assertEquals(1991, result.getPublicationYear());
        assertEquals("S1", result.getSignature());
        assertEquals(BookStatus.AVAILABLE, result.getBookStatus());
    }

    @Test
    public void testMapToBookDtoList() {
        //Given
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE));

        //When
        List<BookDto> result = bookMapper.mapToBookDtoList(bookList);

        //Then
        assertEquals(1L, result.get(0).getId());
        assertEquals("Title1", result.get(0).getTitle());
        assertEquals("Name1", result.get(0).getAuthorName());
        assertEquals("Surname1", result.get(0).getAuthorSurname());
        assertEquals(1991, result.get(0).getPublicationYear());
        assertEquals("S1", result.get(0).getSignature());
        assertEquals(BookStatus.AVAILABLE, result.get(0).getBookStatus());
    }

}

