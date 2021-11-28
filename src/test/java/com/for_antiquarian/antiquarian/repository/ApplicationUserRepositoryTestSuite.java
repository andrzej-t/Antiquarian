package com.for_antiquarian.antiquarian.repository;

import com.for_antiquarian.antiquarian.auth.ApplicationUser;
import com.for_antiquarian.antiquarian.auth.RealApplicationDaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static com.for_antiquarian.antiquarian.security.ApplicationUserRole.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ApplicationUserRepositoryTestSuite {

    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    RealApplicationDaoService realApplicationDaoService;

    @Test
    void shouldSave() {

        //Given
        ApplicationUser applicationUser1 = new ApplicationUser(null, READER.getGrantedAuthorities(), realApplicationDaoService.getPasswordEncoder().encode("reader"), "reader", true, true, true, true);
        ApplicationUser applicationUser2 = new ApplicationUser(null, READER.getGrantedAuthorities(), realApplicationDaoService.getPasswordEncoder().encode("librarian"), "librarian", true, true, true, true);
        ApplicationUser applicationUser3 = new ApplicationUser(null,READER.getGrantedAuthorities(), realApplicationDaoService.getPasswordEncoder().encode("admin"), "admin", true, true, true, true);

        //When
        applicationUserRepository.save(applicationUser1);
        applicationUserRepository.save(applicationUser2);
        applicationUserRepository.save(applicationUser3);

        //Then
        Long id1 = applicationUser1.getId();
        Long id2 = applicationUser2.getId();
        Long id3 = applicationUser3.getId();

        Optional<ApplicationUser> findApplicationUser1 = applicationUserRepository.findById(id1);
        Optional<ApplicationUser> findApplicationUser2 = applicationUserRepository.findById(id2);
        Optional<ApplicationUser> findApplicationUser3 = applicationUserRepository.findById(id3);

        assertTrue(findApplicationUser1.isPresent());
        assertTrue(findApplicationUser2.isPresent());
        assertTrue(findApplicationUser3.isPresent());

        //CleanUp
        applicationUserRepository.deleteById(id1);
        applicationUserRepository.deleteById(id2);
        applicationUserRepository.deleteById(id3);

    }

}

