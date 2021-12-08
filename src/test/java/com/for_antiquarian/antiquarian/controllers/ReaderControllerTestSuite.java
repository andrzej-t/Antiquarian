//package com.for_antiquarian.antiquarian.controllers;
//
//import com.for_antiquarian.antiquarian.domain.Reader;
//import com.for_antiquarian.antiquarian.domain.ReaderDto;
//import com.for_antiquarian.antiquarian.domain.Status;
//import com.for_antiquarian.antiquarian.facade.ReaderFacade;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.hamcrest.Matchers.emptyOrNullString;
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.Mockito.when;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@SpringJUnitWebConfig
//@WebMvcTest(ReaderController.class)
//public class ReaderControllerTestSuite {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ReaderFacade readerFacade;
//
//    @Test
//    @WithMockUser(username = "admin", password = "admin", authorities = "reader:showAll")
//    void testShouldGetAllReaders() throws Exception {
//
//        //Given
//        List<ReaderDto> readerDtoList = new ArrayList<>();
//        readerDtoList.add(new ReaderDto(1L, "Name1", "Surname1", LocalDate.of(2021, 9, 1), null, "email1", "address1", 123456789, Status.ACTIVE));
//        readerDtoList.add(new ReaderDto(2L, "Name2", "Surname2", LocalDate.of(2021, 9, 2), null, "email2", "address2", 234567890, Status.SIGNED_OUT));
//        when(readerFacade.showAllReaders()).thenReturn(readerDtoList);
//
//        //When & Then
//        mockMvc.perform(formLogin("/v1/reader/all").user("admin").password("admin")
//                        .acceptMediaType(MediaType.APPLICATION_JSON)
//                )
//                .andExpect(status().is(200))
//                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].readerName").value("Name1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].readerName").value("Name2"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].readerSurname").value("Surname1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].readerSurname").value("Surname2"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].accountFrom").value("2021-09-01"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].accountFrom").value("2021-09-02"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].accountTo").value(emptyOrNullString()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].accountTo").value(emptyOrNullString()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].readerEmail").value("email1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].readerEmail").value("email2"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].readerAddress").value("address1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].readerAddress").value("address2"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].readerPhoneNumber").value(123456789))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].readerPhoneNumber").value(234567890))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].status").value("ACTIVE"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].status").value("SIGNED_OUT"));
//    }
//
//    @Test
//    @WithMockUser(username = "admin", password = "admin", authorities = "reader:findBySurname")
//    void testShouldFindReaderBySurname() throws Exception {
//
//        //Given
//        List<ReaderDto> readerDtoList = new ArrayList<>();
//        readerDtoList.add(new ReaderDto(1L, "Name1", "Surname1", LocalDate.of(2021, 9, 1), null, "email1", "address1", 123456789, Status.ACTIVE));
//        readerDtoList.add(new ReaderDto(2L, "Name2", "Surname1", LocalDate.of(2021, 9, 2), null, "email2", "address2", 234567890, Status.SIGNED_OUT));
//        when(readerFacade.showReaderBySurname("Surname1")).thenReturn(readerDtoList);
//
//        //When & Then
//        mockMvc.perform(formLogin("/v1/reader/surname?readerSurname=Surname1").user("admin").password("admin")
//                        .acceptMediaType(MediaType.APPLICATION_JSON)
//                )
//                .andExpect(status().is(200))
//                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].readerName").value("Name1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].readerName").value("Name2"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].readerSurname").value("Surname1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].readerSurname").value("Surname1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].accountFrom").value("2021-09-01"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].accountFrom").value("2021-09-02"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].accountTo").value(emptyOrNullString()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].accountTo").value(emptyOrNullString()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].readerEmail").value("email1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].readerEmail").value("email2"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].readerAddress").value("address1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].readerAddress").value("address2"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].readerPhoneNumber").value(123456789))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].readerPhoneNumber").value(234567890))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].status").value("ACTIVE"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].status").value("SIGNED_OUT"));
//    }
//
//    @Test
//    @WithMockUser(username = "admin", password = "admin", authorities = "reader:findById")
//    void testShouldFindReaderById() throws Exception {
//
//        //Given
//        Optional<Reader> reader = Optional.of(new Reader(1L, "Name1", "Surname1", LocalDate.of(2021, 9, 1), null, "email1", "address1", 123456789, Status.ACTIVE));
//        when(readerFacade.showReaderById(1L)).thenReturn(reader);
//
//        //When & Then
//        mockMvc.perform(formLogin("/v1/reader/1").user("admin").password("admin")
//                        .acceptMediaType(MediaType.APPLICATION_JSON)
//                )
//                .andExpect(status().is(200))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.readerName").value("Name1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.readerSurname").value("Surname1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.accountFrom").value("2021-09-01"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.accountTo").value(emptyOrNullString()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.readerEmail").value("email1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.readerAddress").value("address1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.readerPhoneNumber").value(123456789))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("ACTIVE"));
//    }
//
//}
//
