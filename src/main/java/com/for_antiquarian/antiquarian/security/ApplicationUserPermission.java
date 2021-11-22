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
    ADD_NEW_BOOK("book:add"),
    ACTUALIZE_BOOK_STATUS("book:actualizeStatus"),
    ACTUALIZE_BOOK_SIGNATURE("book:actualizeSignature"),
    SHOW_ALL_READERS("reader:showAll"),
    SHOW_ALL_BORROWINGS("borrowing:showAll"),
    FIND_READER_BY_SURNAME("reader:findBySurname"),
    FIND_READER_BY_ID("reader:findById"),
    ADD_BORROWING("borrowing:add");

    private final String permission;
}

