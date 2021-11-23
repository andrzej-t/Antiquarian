package com.for_antiquarian.antiquarian.controllers;

import com.for_antiquarian.antiquarian.domain.BorrowingDto;
import com.for_antiquarian.antiquarian.facade.BorrowingFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @GetMapping(value = "/all")
    @PreAuthorize("hasAnyAuthority('borrowing:showAll')")
    public List<BorrowingDto> getAllBorrowings() {
        return borrowingFacade.showAllBorrowings();
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('borrowing:add')")
    public void addBorrowing(@RequestBody BorrowingDto borrowingDto) {
        borrowingFacade.addNewBorrowing(borrowingDto);
    }

    @GetMapping(value = "/readerId/{id}")
    @PreAuthorize("hasAnyAuthority('borrowing:findByReaderId')")
    public List<BorrowingDto> findBorrowingsByReaderId(@PathVariable Long id) {
        return borrowingFacade.showBorrowingsByReaderId(id);
    }

}

