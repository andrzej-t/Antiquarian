package com.for_antiquarian.antiquarian.repository;

import com.for_antiquarian.antiquarian.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
