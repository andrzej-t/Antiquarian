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
    LIBRARIAN(Sets.newHashSet(SHOW_ALL_BOOKS, BORROW_BOOK, RETURN_BOOK)),
    ADMIN(Sets.newHashSet(SHOW_ALL_BOOKS,CREATE_LIBRARIAN_ACCOUNT, BLOCK_LIBRARIAN_ACCOUNT));

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
