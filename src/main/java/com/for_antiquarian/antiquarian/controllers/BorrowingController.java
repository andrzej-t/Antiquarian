package com.for_antiquarian.antiquarian.controllers;

import com.for_antiquarian.antiquarian.domain.BorrowingDto;
import com.for_antiquarian.antiquarian.exception.IdNotFoundException;
import com.for_antiquarian.antiquarian.facade.BorrowingFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/borrowing")
@RequiredArgsConstructor
public class BorrowingController {

    @Autowired
    BorrowingFacade borrowingFacade;

    @RequestMapping(value = "/all", method = {RequestMethod.GET, RequestMethod.POST})
    @PreAuthorize("hasAnyAuthority('borrowing:showAll')")
    public List<BorrowingDto> getAllBorrowings() {
        return borrowingFacade.showAllBorrowings();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('borrowing:add')")
    public void addBorrowing(@RequestParam Long bookId, @RequestParam Long readerId) {
        try {
            borrowingFacade.addNewBorrowing(bookId, readerId);
        } catch (IdNotFoundException e) {
            System.out.println("There is no book or reader with this \"id\"");
        }
    }

    @RequestMapping(value = "/readerId/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    @PreAuthorize("hasAnyAuthority('borrowing:findByReaderId')")
    public List<BorrowingDto> findBorrowingsByReaderId(@PathVariable Long id) {
        return borrowingFacade.showBorrowingsByReaderId(id);
    }

    @RequestMapping(value = "/bookId/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    @PreAuthorize("hasAnyAuthority('borrowing:findByBookId')")
    public List<BorrowingDto> findBorrowingsByBookId(@PathVariable Long id) {
        return borrowingFacade.showBorrowingsByBookId(id);
    }

}

