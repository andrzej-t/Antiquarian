package com.for_antiquarian.antiquarian.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApplicationUserPermission {

    SHOW_ALL_BOOKS("book:showAll"),
    SHOW_BOOK_BY_ID("book:showBookById"),
    SHOW_BOOK_BY_TITLE("book:showBookByTitle"),
    SHOW_BOOK_BY_AUTHOR("book:showBookByAuthor"),
    SHOW_BOOK_BY_SIGNATURE("book:showBookBySignature"),
    SHOW_ALL_READERS("reader:showAll");

    private final String permission;
}

