package com.for_antiquarian.antiquarian.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApplicationUserPermission {

    BORROW_BOOK("book:borrow"),
    SHOW_ALL_BOOKS("book:showAll"),
    RETURN_BOOK("book:return"),
    CREATE_LIBRARIAN_ACCOUNT("librarianAccount:create"),
    BLOCK_LIBRARIAN_ACCOUNT("librarianAccount:block");

    private final String permission;

}
