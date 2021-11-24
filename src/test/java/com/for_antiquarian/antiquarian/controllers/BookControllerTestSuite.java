package com.for_antiquarian.antiquarian.controllers;

import com.for_antiquarian.antiquarian.domain.BookDto;
import com.for_antiquarian.antiquarian.domain.BookStatus;
import com.for_antiquarian.antiquarian.facade.BookFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringJUnitWebConfig
@WebMvcTest(BookController.class)
public class BookControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookFacade bookFacade;

    @Test
    public void testShouldGetAllBooks() throws Exception {

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
                .andExpect(MockMvcResultMatchers.status().is(200))
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

}

