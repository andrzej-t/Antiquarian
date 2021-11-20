package com.for_antiquarian.antiquarian.repository;

import com.for_antiquarian.antiquarian.domain.Borrowing;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing, Long> {

    @Override
    List<Borrowing> findAll();

    @Modifying
    @Query
    void setReturnDate(@Param("DATE") LocalDate dateOfReturn, @Param("FETCHED_ID") Long fetchedId);

    @Modifying
    @Query
    void setBorrowDate(@Param("DATE") LocalDate dateOfBorrowing, @Param("FETCHED_ID") Long fetchedId);

}

