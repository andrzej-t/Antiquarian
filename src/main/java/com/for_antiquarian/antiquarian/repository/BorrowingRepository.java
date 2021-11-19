package com.for_antiquarian.antiquarian.repository;

import com.for_antiquarian.antiquarian.domain.Borrowing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing, Long> {

    @Override
    List<Borrowing> findAll();
}

