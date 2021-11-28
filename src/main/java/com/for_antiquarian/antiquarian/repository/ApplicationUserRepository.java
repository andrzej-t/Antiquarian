package com.for_antiquarian.antiquarian.repository;

import com.for_antiquarian.antiquarian.auth.ApplicationUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {

    @Override
    List<ApplicationUser> findAll();

}

