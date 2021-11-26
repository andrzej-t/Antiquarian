package com.for_antiquarian.antiquarian.controllers;

import com.for_antiquarian.antiquarian.domain.Book;
import com.for_antiquarian.antiquarian.domain.BookDto;
import com.for_antiquarian.antiquarian.domain.BookStatus;
import com.for_antiquarian.antiquarian.facade.BookFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/book")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    BookFacade bookFacade;

    @GetMapping(value = "/all")
    @PreAuthorize("hasAnyAuthority('book:showAll')")
    public List<BookDto> getAllBooks() {
        return bookFacade.showAllBooks();
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyAuthority('book:showBookById')")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookFacade.showBookById(id);
    }

    @GetMapping(value = "/title")
    @PreAuthorize("hasAnyAuthority('book:showBookByTitle')")
    public List<BookDto> getBookByTitle(@RequestParam("title") String title) {
        return bookFacade.showBookByTitle(title);
    }

    @GetMapping(value = "/author")
    @PreAuthorize("hasAnyAuthority('book:showBookByAuthor')")
    public List<BookDto> getBookByAuthorSurname(@RequestParam String authorSurname) {
        return bookFacade.showBookByAuthorSurname(authorSurname);
    }

    @GetMapping(value = "/signature")
    @PreAuthorize("hasAnyAuthority('book:showBookBySignature')")
    public Optional<Book> getBookBySignature(@RequestParam String signature) {
        return bookFacade.showBookBySignature(signature);
    }

    @PutMapping(value = "/changeStatus")
    @PreAuthorize("hasAnyAuthority('book:actualizeStatus')")
    public void changeStatus(@RequestParam Long id, @RequestParam BookStatus bookStatus) {
        try {
            bookFacade.updateStatus(id, bookStatus);
        } catch (Exception e) {
            System.out.println("There is no book with this \"id\"");
        }
    }

    @PutMapping(value = "/changeSignature")
    @PreAuthorize("hasAnyAuthority('book:actualizeSignature')")
    public void updateSignature(@RequestParam Long id, @RequestParam String signature) {
        try {
            bookFacade.updateSignature(id, signature);
        } catch (Exception e) {
            System.out.println("There is no book with this \"id\"");
        }
    }

    @PostMapping(value = "/add")
    @PreAuthorize("hasAnyAuthority('book:add')")
    public void addBook(@RequestBody BookDto bookDto) {
        try {
            bookFacade.addNewBook(bookDto);
        } catch (Exception e) {
            System.out.println("Book with this \"id\" already exists in the database");
        }
    }

}

