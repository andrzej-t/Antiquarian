package com.for_antiquarian.antiquarian.facade;

import com.for_antiquarian.antiquarian.domain.Book;
import com.for_antiquarian.antiquarian.mapper.BookMapper;
import com.for_antiquarian.antiquarian.service.BookService;
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
public class BookFacade {

    @Autowired
    BookService bookService;

    @Autowired
    BookMapper bookMapper;

    public List<Book> showAllBooks() { return bookService.findAllBooks(); }

}
