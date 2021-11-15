package com.for_antiquarian.antiquarian.repository;

import com.for_antiquarian.antiquarian.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long> {
}
