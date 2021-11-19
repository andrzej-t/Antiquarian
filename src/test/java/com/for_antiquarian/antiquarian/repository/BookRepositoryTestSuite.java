package com.for_antiquarian.antiquarian.repository;

import com.for_antiquarian.antiquarian.domain.Book;
import com.for_antiquarian.antiquarian.domain.BookStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BookRepositoryTestSuite {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testBookRepositorySave() {

        //Given
        Book book1 = new Book(null, "Title1", "Name1", "Surname1", 1993, "signature126432", BookStatus.AVAILABLE);
//        Book book2 = new Book(null, "Title2", "Name2", "Surname2", 1993, "signature2", BookStatus.AVAILABLE);

        //When
        bookRepository.save(book1);
//        bookRepository.save(book2);

        //Then
        Long id = book1.getId();
        Optional<Book> findBook = bookRepository.findById(id);
        assertTrue(findBook.isPresent());

        //CleanUp
        bookRepository.deleteById(id);
    }

//    @Test
//    public void testBookRepositoryDeleteAll() {
//
//        //When
//        bookRepository.deleteAll();
//
//    }

}
