package com.for_antiquarian.antiquarian.controllers;

import com.for_antiquarian.antiquarian.domain.BorrowingDto;
import com.for_antiquarian.antiquarian.facade.BorrowingFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

