package com.for_antiquarian.antiquarian.auth;

import com.for_antiquarian.antiquarian.repository.ApplicationUserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Getter
@Repository("real")
public class RealApplicationDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    public RealApplicationDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {

        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() { return applicationUserRepository.findAll(); }

}

