package com.for_antiquarian.antiquarian.facade;

import com.for_antiquarian.antiquarian.domain.Book;
import com.for_antiquarian.antiquarian.domain.BookDto;
import com.for_antiquarian.antiquarian.mapper.BookMapper;
import com.for_antiquarian.antiquarian.service.BookService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
public class BookFacade {

    @Autowired
    BookService bookService;

    @Autowired
    BookMapper bookMapper;

    public List<BookDto> showAllBooks() {
        return bookService.findAllBooks();
    }

    public Optional<Book> showBookById(Long id) {
        return bookService.findBookById(id);
    }

    public List<BookDto> showBookByTitle(String title) {
        return bookService.findBookByTitle(title);
    }

    public List<BookDto> showBookByAuthorSurname(String authorSurname) {
        return bookService.findBookByAuthorSurname(authorSurname);
    }

    public Optional<Book> showBookBySignature(String signature) {
        return bookService.findBookBySignature(signature);
    }

    public void updateStatus(BookDto bookDto) {
        bookService.actualizeStatus(bookDto);
    }
}

