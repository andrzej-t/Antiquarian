package com.for_antiquarian.antiquarian.controllers;

import com.for_antiquarian.antiquarian.domain.*;
import com.for_antiquarian.antiquarian.facade.BorrowingFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig
@WebMvcTest(BorrowingController.class)
public class BorrowingControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BorrowingFacade borrowingFacade;
    @MockBean
    Borrowing borrowing;


    @Test
    void testShouldGetAllBorrowings() throws Exception {

        //Given
        List<BorrowingDto> borrowingDtoList = new ArrayList<>();
        Book book1 = new Book(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE);
        Book book2 = new Book(2L, "Title2", "Name2", "Surname2", 1991, "S2", BookStatus.AVAILABLE);
        Reader reader1 = new Reader(3L, "Name3", "Surname3", LocalDate.of(2021, 9, 1), null, "email3", "address3", 123456789, ReaderStatus.ACTIVE);
        Reader reader2 = new Reader(4L, "Name4", "Surname4", LocalDate.of(2021, 9, 1), null, "email4", "address4", 123456789, ReaderStatus.ACTIVE);
        borrowingDtoList.add(new BorrowingDto(5L, LocalDate.of(2021, 1, 12), LocalDate.of(2021, 1, 19), book1, reader1));
        borrowingDtoList.add(new BorrowingDto(6L, LocalDate.of(2021, 1, 12), LocalDate.of(2021, 1, 19), book2, reader2));
        when(borrowingFacade.showAllBorrowings()).thenReturn(borrowingDtoList);

        //When & Then
        mockMvc.perform(get("/v1/borrowing/all")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("Adam Nowak", "password2"))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(5)))
                .andExpect(jsonPath("$[1].id", is(6)))
                .andExpect(jsonPath("$[0].borrowDate", is("2021-01-12")))
                .andExpect(jsonPath("$[1].borrowDate", is("2021-01-12")))
                .andExpect(jsonPath("$[0].returnDate", is("2021-01-19")))
                .andExpect(jsonPath("$[1].returnDate", is("2021-01-19")))
                .andExpect(jsonPath("$[0].returnDate", is("2021-01-19")));

    }

    @Test
    void testShouldAddBorrowing() throws Exception {

        //Given & When & Then
        mockMvc.perform(post("/v1/borrowing/add?bookId=1&readerId=3")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("Adam Nowak", "password2"))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(200));
    }

    @Test
    void testShouldFindBorrowingsByReaderId() throws Exception {

        //Given
        List<BorrowingDto> borrowingDtoList = new ArrayList<>();
        Book book1 = new Book(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE);
        Book book2 = new Book(2L, "Title2", "Name2", "Surname2", 1991, "S2", BookStatus.AVAILABLE);
        Reader reader1 = new Reader(3L, "Name3", "Surname3", LocalDate.of(2021, 9, 1), null, "email3", "address3", 123456789, ReaderStatus.ACTIVE);
        borrowingDtoList.add(new BorrowingDto(5L, LocalDate.of(2021, 1, 12), LocalDate.of(2021, 1, 19), book1, reader1));
        borrowingDtoList.add(new BorrowingDto(6L, LocalDate.of(2021, 1, 12), LocalDate.of(2021, 1, 19), book2, reader1));
        when(borrowingFacade.showBorrowingsByReaderId(1L)).thenReturn(borrowingDtoList);

        //When & Then
        mockMvc.perform(get("/v1/borrowing/readerId/1")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("Adam Nowak", "password2"))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(5)))
                .andExpect(jsonPath("$[1].id", is(6)))
                .andExpect(jsonPath("$[0].borrowDate", is("2021-01-12")))
                .andExpect(jsonPath("$[1].borrowDate", is("2021-01-12")))
                .andExpect(jsonPath("$[0].returnDate", is("2021-01-19")))
                .andExpect(jsonPath("$[1].returnDate", is("2021-01-19")));
    }

}

