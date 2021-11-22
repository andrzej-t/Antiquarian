package com.for_antiquarian.antiquarian.security;

import com.google.common.collect.Sets;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.for_antiquarian.antiquarian.security.ApplicationUserPermission.*;

@Getter
public enum ApplicationUserRole {
    READER(Sets.newHashSet()),
    LIBRARIAN(Sets.newHashSet(SHOW_ALL_BOOKS, SHOW_BOOK_BY_ID, SHOW_BOOK_BY_TITLE, SHOW_BOOK_BY_AUTHOR, SHOW_BOOK_BY_SIGNATURE, SHOW_ALL_READERS, SHOW_ALL_BORROWINGS, ACTUALIZE_BOOK_STATUS,
            ADD_NEW_BOOK, ACTUALIZE_BOOK_SIGNATURE, FIND_READER_BY_SURNAME, FIND_READER_BY_ID, ADD_BORROWING)),
    ADMIN(Sets.newHashSet(SHOW_ALL_BOOKS, SHOW_BOOK_BY_ID, SHOW_BOOK_BY_TITLE, SHOW_BOOK_BY_AUTHOR, SHOW_BOOK_BY_SIGNATURE, SHOW_ALL_READERS, SHOW_ALL_BORROWINGS, ACTUALIZE_BOOK_STATUS,
            ADD_NEW_BOOK, ACTUALIZE_BOOK_SIGNATURE, FIND_READER_BY_SURNAME, FIND_READER_BY_ID, ADD_BORROWING));

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    private final Set<ApplicationUserPermission> permissions;

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissions;
    }
}

