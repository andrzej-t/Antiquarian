package com.for_antiquarian.antiquarian.service;

import com.for_antiquarian.antiquarian.domain.Book;
import com.for_antiquarian.antiquarian.domain.BookDto;
import com.for_antiquarian.antiquarian.domain.BookStatus;
import com.for_antiquarian.antiquarian.domain.Borrowing;
import com.for_antiquarian.antiquarian.mapper.BookMapper;
import com.for_antiquarian.antiquarian.repository.BookRepository;
import com.for_antiquarian.antiquarian.repository.BorrowingRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("OptionalGetWithoutIsPresent")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BorrowingRepository borrowingRepository;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    Borrowing borrowing;

    public List<BookDto> findAllBooks() {
        return bookMapper.mapToBookDtoList(bookRepository.findAll());
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public List<BookDto> findBookByTitle(String title) {
        return bookMapper.mapToBookDtoList(bookRepository.findAllByTitle(title));
    }

    public List<BookDto> findBookByAuthorSurname(String authorSurname) {
        return bookMapper.mapToBookDtoList(bookRepository.findAllByAuthorSurname(authorSurname));
    }

    public Optional<Book> findBookBySignature(String signature) {
        return bookRepository.findBySignature(signature);
    }

    @Transactional
    public void actualizeStatus(Long id, BookStatus bookStatus) {

        if (bookRepository.findById(id).get().getBookStatus().equals(BookStatus.BORROWED) && bookStatus.equals(BookStatus.AVAILABLE)) {

            borrowingRepository.setReturnDate(LocalDate.now(), id);
            bookRepository.findById(id).get().setBookStatus(bookStatus);
        } else if (bookRepository.findById(id).get().getBookStatus().equals(BookStatus.AVAILABLE) && bookStatus.equals(BookStatus.BORROWED)) {

            borrowingRepository.setBorrowDate(LocalDate.now(), id);
            bookRepository.findById(id).get().setBookStatus(bookStatus);
        } else {
            bookRepository.findById(id).get().setBookStatus(bookStatus);
        }

    }

    @Transactional
    public void actualizeSignature(BookDto bookDto) {
        bookRepository.findById(bookDto.getId()).get().setSignature(bookDto.getSignature());
    }

    @Transactional
    public void insertNewBook(BookDto bookDto) {
        bookRepository.save(bookMapper.mapToBook(bookDto));
    }

}

