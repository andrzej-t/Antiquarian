package com.for_antiquarian.antiquarian.service;

import com.for_antiquarian.antiquarian.domain.Book;
import com.for_antiquarian.antiquarian.domain.BookDto;
import com.for_antiquarian.antiquarian.mapper.BookMapper;
import com.for_antiquarian.antiquarian.repository.BookRepository;
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
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookMapper bookMapper;

    public List<BookDto> findAllBooks() { return bookMapper.mapToBookDtoList(bookRepository.findAll()); }

    public Optional<Book> findBookById(Long id) { return bookRepository.findById(id); }

    public List<BookDto> findBookByTitle(String title) { return bookMapper.mapToBookDtoList(bookRepository.findAllByTitle(title)); }

    public List<BookDto> findBookByAuthorSurname(String authorSurname) { return bookMapper.mapToBookDtoList(bookRepository.findAllByAuthorSurname(authorSurname)); }

    public Optional<Book> findBookBySignature(String signature) { return bookRepository.findBySignature(signature); }
}
