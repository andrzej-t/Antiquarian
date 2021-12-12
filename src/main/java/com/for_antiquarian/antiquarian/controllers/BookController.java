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

    @RequestMapping(value = "/all", method = {RequestMethod.GET, RequestMethod.POST})
    @PreAuthorize("hasAnyAuthority('book:showAll')")
    public List<BookDto> getAllBooks() {
        return bookFacade.showAllBooks();
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    @PreAuthorize("hasAnyAuthority('book:showBookById')")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookFacade.showBookById(id);
    }

    @RequestMapping(value = "/title", method = {RequestMethod.GET, RequestMethod.POST})
    @PreAuthorize("hasAnyAuthority('book:showBookByTitle')")
    public List<BookDto> getBookByTitle(@RequestParam("title") String title) {
        return bookFacade.showBookByTitle(title);
    }

    @RequestMapping(value = "/author", method = {RequestMethod.GET, RequestMethod.POST})
    @PreAuthorize("hasAnyAuthority('book:showBookByAuthor')")
    public List<BookDto> getBookByAuthorSurname(@RequestParam String authorSurname) {
        return bookFacade.showBookByAuthorSurname(authorSurname);
    }

    @RequestMapping(value = "/signature", method = {RequestMethod.GET, RequestMethod.POST})
    @PreAuthorize("hasAnyAuthority('book:showBookBySignature')")
    public Optional<Book> getBookBySignature(@RequestParam String signature) {
        return bookFacade.showBookBySignature(signature);
    }

    @RequestMapping(value = "/changeStatus/{id}", method = {RequestMethod.PUT, RequestMethod.POST})
    @PreAuthorize("hasAnyAuthority('book:actualizeStatus')")
    public void changeStatus(@PathVariable Long id, @RequestParam BookStatus bookStatus) {
        try {
            bookFacade.updateStatus(id, bookStatus);
        } catch (Exception e) {
            System.out.println("There is no book with this \"id\"");
        }
    }

    @RequestMapping(value = "/changeSignature/{id}", method = {RequestMethod.PUT, RequestMethod.POST})
    @PreAuthorize("hasAnyAuthority('book:actualizeSignature')")
    public void updateSignature(@PathVariable Long id, @RequestParam String signature) {
        try {
            bookFacade.updateSignature(id, signature);
        } catch (Exception e) {
            System.out.println("There is no book with this \"id\"");
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('book:add')")
    public void addBook(@RequestBody BookDto bookDto) {
        try {
            bookFacade.addNewBook(bookDto);
        } catch (Exception e) {
            System.out.println("Book with this reference number already exists in the database");
        }
    }

}

