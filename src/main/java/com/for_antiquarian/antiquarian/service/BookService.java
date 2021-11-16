package com.for_antiquarian.antiquarian.service;

import com.for_antiquarian.antiquarian.domain.Book;
import com.for_antiquarian.antiquarian.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}
