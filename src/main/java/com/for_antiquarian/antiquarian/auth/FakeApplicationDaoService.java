package com.for_antiquarian.antiquarian.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.for_antiquarian.antiquarian.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {

        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {

        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        READER.getGrantedAuthorities(),
                        passwordEncoder.encode("password1"),
                        "Jan Kowalski",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        LIBRARIAN.getGrantedAuthorities(),
                        passwordEncoder.encode("password2"),
                        "Adam Nowak",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMIN.getGrantedAuthorities(),
                        passwordEncoder.encode("password3"),
                        "Katarzyna Nowacka",
                        true,
                        true,
                        true,
                        true
                )
        );
        return applicationUsers;
    }

}

