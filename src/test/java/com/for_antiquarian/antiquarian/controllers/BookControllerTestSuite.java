package com.for_antiquarian.antiquarian.controllers;

import com.for_antiquarian.antiquarian.domain.Book;
import com.for_antiquarian.antiquarian.domain.BookDto;
import com.for_antiquarian.antiquarian.domain.BookStatus;
import com.for_antiquarian.antiquarian.facade.BookFacade;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig
@WebMvcTest(BookController.class)
public class BookControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookFacade bookFacade;

    @Test
    void testShouldGetAllBooks() throws Exception {

        //Given
        List<BookDto> bookDtoList = new ArrayList<>();
        bookDtoList.add(new BookDto(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE));
        bookDtoList.add(new BookDto(2L, "Title2", "Name2", "Surname2", 1992, "S2", BookStatus.AVAILABLE));
        when(bookFacade.showAllBooks()).thenReturn(bookDtoList);

        //When & Then
        mockMvc.perform(get("/v1/book/all")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("Adam Nowak", "password2"))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[0].title", is("Title1")))
                .andExpect(jsonPath("$[1].title", is("Title2")))
                .andExpect(jsonPath("$[0].authorName", is("Name1")))
                .andExpect(jsonPath("$[1].authorName", is("Name2")))
                .andExpect(jsonPath("$[0].authorSurname", is("Surname1")))
                .andExpect(jsonPath("$[1].authorSurname", is("Surname2")))
                .andExpect(jsonPath("$[0].publicationYear", is(1991)))
                .andExpect(jsonPath("$[1].publicationYear", is(1992)))
                .andExpect(jsonPath("$[0].signature", is("S1")))
                .andExpect(jsonPath("$[1].signature", is("S2")))
                .andExpect(jsonPath("$[0].bookStatus", is("AVAILABLE")))
                .andExpect(jsonPath("$[1].bookStatus", is("AVAILABLE")));
    }

    @Test
    void testShouldGetBookById() throws Exception {

        //Given
        Optional<Book> book = Optional.of(new Book(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE));
        when(bookFacade.showBookById(1L)).thenReturn(book);

        //When & Then
        mockMvc.perform(get("/v1/book/1")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("Adam Nowak", "password2"))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Title1")))
                .andExpect(jsonPath("$.authorName", is("Name1")))
                .andExpect(jsonPath("$.authorSurname", is("Surname1")))
                .andExpect(jsonPath("$.publicationYear", is(1991)))
                .andExpect(jsonPath("$.signature", is("S1")))
                .andExpect(jsonPath("$.bookStatus", is("AVAILABLE")));
    }

    @Test
    void testShouldGetBookByTitle() throws Exception {

        //Given
        List<BookDto> bookDtoList = new ArrayList<>();
        bookDtoList.add(new BookDto(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE));
        bookDtoList.add(new BookDto(2L, "Title1", "Name2", "Surname2", 1992, "S2", BookStatus.AVAILABLE));
        when(bookFacade.showBookByTitle("Title1")).thenReturn(bookDtoList);

        //When & Then
        mockMvc.perform(get("/v1/book/title?title=Title1")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("Adam Nowak", "password2"))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[0].title", is("Title1")))
                .andExpect(jsonPath("$[1].title", is("Title1")))
                .andExpect(jsonPath("$[0].authorName", is("Name1")))
                .andExpect(jsonPath("$[1].authorName", is("Name2")))
                .andExpect(jsonPath("$[0].authorSurname", is("Surname1")))
                .andExpect(jsonPath("$[1].authorSurname", is("Surname2")))
                .andExpect(jsonPath("$[0].publicationYear", is(1991)))
                .andExpect(jsonPath("$[1].publicationYear", is(1992)))
                .andExpect(jsonPath("$[0].signature", is("S1")))
                .andExpect(jsonPath("$[1].signature", is("S2")))
                .andExpect(jsonPath("$[0].bookStatus", is("AVAILABLE")))
                .andExpect(jsonPath("$[1].bookStatus", is("AVAILABLE")));
    }

    @Test
    void testShouldGetBookByAuthorSurname() throws Exception {

        //Given
        List<BookDto> bookDtoList = new ArrayList<>();
        bookDtoList.add(new BookDto(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE));
        bookDtoList.add(new BookDto(2L, "Title2", "Name2", "Surname1", 1992, "S2", BookStatus.AVAILABLE));
        when(bookFacade.showBookByAuthorSurname("Surname1")).thenReturn(bookDtoList);

        //When & Then
        mockMvc.perform(get("/v1/book/author?authorSurname=Surname1")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("Adam Nowak", "password2"))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[0].title", is("Title1")))
                .andExpect(jsonPath("$[1].title", is("Title2")))
                .andExpect(jsonPath("$[0].authorName", is("Name1")))
                .andExpect(jsonPath("$[1].authorName", is("Name2")))
                .andExpect(jsonPath("$[0].authorSurname", is("Surname1")))
                .andExpect(jsonPath("$[1].authorSurname", is("Surname1")))
                .andExpect(jsonPath("$[0].publicationYear", is(1991)))
                .andExpect(jsonPath("$[1].publicationYear", is(1992)))
                .andExpect(jsonPath("$[0].signature", is("S1")))
                .andExpect(jsonPath("$[1].signature", is("S2")))
                .andExpect(jsonPath("$[0].bookStatus", is("AVAILABLE")))
                .andExpect(jsonPath("$[1].bookStatus", is("AVAILABLE")));
    }

    @Test
    void testShouldGetBookBySignature() throws Exception {

        //Given
        Optional<Book> book = Optional.of(new Book(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE));
        when(bookFacade.showBookBySignature("S1")).thenReturn(book);

        //When & Then
        mockMvc.perform(get("/v1/book/signature?signature=S1")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("Adam Nowak", "password2"))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Title1")))
                .andExpect(jsonPath("$.authorName", is("Name1")))
                .andExpect(jsonPath("$.authorSurname", is("Surname1")))
                .andExpect(jsonPath("$.publicationYear", is(1991)))
                .andExpect(jsonPath("$.signature", is("S1")))
                .andExpect(jsonPath("$.bookStatus", is("AVAILABLE")));
    }

    @Test
    void testShouldUpdateStatus() throws Exception {

        //Given
        BookDto bookDto = new BookDto(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookDto);

        //When & Then
        mockMvc.perform(put("/v1/book/changeStatus")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("Adam Nowak", "password2"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(status().is(200));
    }

    @Test
    void testShouldUpdateSignature() throws Exception {

        //Given
        BookDto bookDto = new BookDto(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookDto);

        //When & Then
        mockMvc.perform(put("/v1/book/changeSignature")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("Adam Nowak", "password2"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(status().is(200));
    }

    @Test
    void testShouldAddBook() throws Exception {

        //Given
        BookDto bookDto = new BookDto(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookDto);

        //When & Then
        mockMvc.perform(post("/v1/book/add")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("Adam Nowak", "password2"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(status().is(200));
    }

}

