package com.for_antiquarian.antiquarian.service;

import com.for_antiquarian.antiquarian.domain.Book;
import com.for_antiquarian.antiquarian.domain.Borrowing;
import com.for_antiquarian.antiquarian.domain.BorrowingDto;
import com.for_antiquarian.antiquarian.domain.Reader;
import com.for_antiquarian.antiquarian.exception.IdNotFoundException;
import com.for_antiquarian.antiquarian.mapper.BorrowingMapper;
import com.for_antiquarian.antiquarian.repository.BookRepository;
import com.for_antiquarian.antiquarian.repository.BorrowingRepository;
import com.for_antiquarian.antiquarian.repository.ReaderRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
public class BorrowingService {

    @Autowired
    BorrowingRepository borrowingRepository;
    @Autowired
    BorrowingMapper borrowingMapper;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ReaderRepository readerRepository;

    public List<BorrowingDto> findAllBorrowings() {
        return borrowingMapper.mapToBorrowingDtoList(borrowingRepository.findAll());
    }

    @Transactional
    public void insertNewBorrowing(Long bookId, Long readerId) throws IdNotFoundException {

        Book fetchedBook = bookRepository.findById(bookId).orElseThrow(IdNotFoundException::new);
        Reader fetchedReader = readerRepository.findById(readerId).orElseThrow(IdNotFoundException::new);

        borrowingRepository.save(new Borrowing(null, LocalDate.now(), null, fetchedBook, fetchedReader));
    }

    @Transactional
    public List<BorrowingDto> getBorrowingsByReaderId(Long id) {

        return borrowingMapper.mapToBorrowingDtoList(borrowingRepository.findByReaderId(id));
    }

}

