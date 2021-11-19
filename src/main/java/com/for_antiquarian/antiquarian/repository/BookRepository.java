package com.for_antiquarian.antiquarian.repository;

import com.for_antiquarian.antiquarian.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    List<Book> findAll();

    @Override
    Optional<Book> findById(Long id);

    List<Book> findAllByTitle(String title);

    List<Book> findAllByAuthorSurname(String authorSurname);

    Optional<Book> findBySignature(String signature);
}

