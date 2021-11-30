package com.for_antiquarian.antiquarian.controllers;

import com.for_antiquarian.antiquarian.domain.Book;
import com.for_antiquarian.antiquarian.domain.BookDto;
import com.for_antiquarian.antiquarian.domain.BookStatus;
import com.for_antiquarian.antiquarian.facade.BookFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig
@WebMvcTest(BookController.class)
public class BookControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookFacade bookFacade;

    @Test
    @WithMockUser(username = "admin", password = "admin", authorities = "book:showAll")
    void testShouldGetAllBooks() throws Exception {

        //Given
        List<BookDto> bookDtoList = new ArrayList<>();
        bookDtoList.add(new BookDto(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE));
        bookDtoList.add(new BookDto(2L, "Title2", "Name2", "Surname2", 1992, "S2", BookStatus.AVAILABLE));
        when(bookFacade.showAllBooks()).thenReturn(bookDtoList);

        //When & Then
        mockMvc.perform(formLogin("/v1/book/all").user("admin").password("admin")
                        .acceptMediaType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Title1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].title").value("Title2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].authorName").value("Name1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].authorName").value("Name2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].authorSurname").value("Surname1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].authorSurname").value("Surname2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].publicationYear").value(1991))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].publicationYear").value(1992))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].signature").value("S1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].signature").value("S2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].bookStatus").value("AVAILABLE"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].bookStatus").value("AVAILABLE"));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", authorities = "book:showBookById")
    void testShouldGetBookById() throws Exception {

        //Given
        Optional<Book> book = Optional.of(new Book(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE));
        when(bookFacade.showBookById(1L)).thenReturn(book);

        //When & Then
        mockMvc.perform(formLogin("/v1/book/1").user("admin").password("admin")
                        .acceptMediaType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Title1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.authorName").value("Name1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.authorSurname").value("Surname1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.publicationYear").value(1991))
                .andExpect(MockMvcResultMatchers.jsonPath("$.signature").value("S1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.bookStatus").value("AVAILABLE"));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", authorities = "book:showBookByTitle")
    void testShouldGetBookByTitle() throws Exception {

        //Given
        List<BookDto> bookDtoList = new ArrayList<>();
        bookDtoList.add(new BookDto(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE));
        bookDtoList.add(new BookDto(2L, "Title1", "Name2", "Surname2", 1992, "S2", BookStatus.AVAILABLE));
        when(bookFacade.showBookByTitle("Title1")).thenReturn(bookDtoList);

        //When & Then
        mockMvc.perform(formLogin("/v1/book/title?title=Title1").user("admin").password("admin")
                        .acceptMediaType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Title1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].title").value("Title1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].authorName").value("Name1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].authorName").value("Name2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].authorSurname").value("Surname1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].authorSurname").value("Surname2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].publicationYear").value(1991))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].publicationYear").value(1992))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].signature").value("S1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].signature").value("S2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].bookStatus").value("AVAILABLE"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].bookStatus").value("AVAILABLE"));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", authorities = "book:showBookByAuthor")
    void testShouldGetBookByAuthorSurname() throws Exception {

        //Given
        List<BookDto> bookDtoList = new ArrayList<>();
        bookDtoList.add(new BookDto(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE));
        bookDtoList.add(new BookDto(2L, "Title2", "Name2", "Surname1", 1992, "S2", BookStatus.AVAILABLE));
        when(bookFacade.showBookByAuthorSurname("Surname1")).thenReturn(bookDtoList);

        //When & Then
        mockMvc.perform(formLogin("/v1/book/author?authorSurname=Surname1").user("admin").password("admin")
                        .acceptMediaType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Title1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].title").value("Title2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].authorName").value("Name1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].authorName").value("Name2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].authorSurname").value("Surname1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].authorSurname").value("Surname1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].publicationYear").value(1991))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].publicationYear").value(1992))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].signature").value("S1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].signature").value("S2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].bookStatus").value("AVAILABLE"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].bookStatus").value("AVAILABLE"));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", authorities = "book:showBookBySignature")
    void testShouldGetBookBySignature() throws Exception {

        //Given
        Optional<Book> book = Optional.of(new Book(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE));
        when(bookFacade.showBookBySignature("S1")).thenReturn(book);

        //When & Then
        mockMvc.perform(formLogin("/v1/book/signature?signature=S1").user("admin").password("admin")
                        .acceptMediaType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Title1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.authorName").value("Name1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.authorSurname").value("Surname1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.publicationYear").value(1991))
                .andExpect(MockMvcResultMatchers.jsonPath("$.signature").value("S1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.bookStatus").value("AVAILABLE"));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", authorities = "book:actualizeSignature")
    void testShouldUpdateSignature() throws Exception {

        //Given & When & Then
        mockMvc.perform(formLogin("/v1/book/changeSignature?id=1&signature=S2").user("admin").password("admin")
                        .acceptMediaType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", authorities = "book:actualizeStatus")
    void testShouldUpdateStatus() throws Exception {

        //Given & When & Then
        mockMvc.perform(formLogin("/v1/book/changeStatus?id=1&bookStatus=LOST").user("admin").password("admin")
                        .acceptMediaType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }

//    @Test
//    @WithMockUser(username = "admin", password = "admin", authorities = "book:add")
//    void testShouldAddBook() throws Exception {
//
//        //Given
//        BookDto bookDto = new BookDto(1L, "Title1", "Name1", "Surname1", 1991, "S1", BookStatus.AVAILABLE);
//
//        Gson gson = new Gson();
//        String jsonContent = gson.toJson(bookDto);
//
//        //When & Then
//        mockMvc.perform(formLogin("/v1/book/add").user("admin").password("admin")
//                        .acceptMediaType(MediaType.APPLICATION_JSON))
//                .andExpect(status().is(200));
//    }

}

