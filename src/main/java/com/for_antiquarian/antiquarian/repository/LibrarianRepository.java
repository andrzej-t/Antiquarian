package com.for_antiquarian.antiquarian.repository;

import com.for_antiquarian.antiquarian.domain.Librarian;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface LibrarianRepository extends CrudRepository<Librarian, Long> {

}

