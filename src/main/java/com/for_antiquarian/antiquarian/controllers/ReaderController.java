package com.for_antiquarian.antiquarian.controllers;

import com.for_antiquarian.antiquarian.domain.ReaderDto;
import com.for_antiquarian.antiquarian.facade.ReaderFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/reader")
@RequiredArgsConstructor
public class ReaderController {

    @Autowired
    ReaderFacade readerFacade;

    @GetMapping(value = "/all")
    @PreAuthorize("hasAnyAuthority('reader:showAll')")
    public List<ReaderDto> getAllReaders() {
        return readerFacade.showAllReaders();
    }

    @GetMapping(value = "/surname")
    @PreAuthorize("hasAnyAuthority('reader:findBySurname')")
    public List<ReaderDto> findReaderBySurname(@RequestParam String readerSurname) {
        return readerFacade.showReaderBySurname(readerSurname);
    }
}

