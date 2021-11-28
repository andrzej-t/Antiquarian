//package com.for_antiquarian.antiquarian.controllers;
//
//import com.for_antiquarian.antiquarian.auth.RealApplicationDaoService;
//import com.for_antiquarian.antiquarian.domain.Reader;
//import com.for_antiquarian.antiquarian.domain.ReaderDto;
//import com.for_antiquarian.antiquarian.domain.Status;
//import com.for_antiquarian.antiquarian.facade.ReaderFacade;
//import com.for_antiquarian.antiquarian.security.ApplicationSecurityConfig;
//import com.for_antiquarian.antiquarian.security.PasswordConfig;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
//import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.hamcrest.Matchers.*;
//import static org.mockito.Mockito.when;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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
//    @Autowired
//    RealApplicationDaoService realApplicationDaoService;
//    @Autowired
//    PasswordConfig passwordConfig;
//    @Autowired
//    ApplicationSecurityConfig applicationSecurityConfig;
//
//    @Test
//    void testShouldGetAllReaders() throws Exception {
//
//        //Given
//        List<ReaderDto> readerDtoList = new ArrayList<>();
//        readerDtoList.add(new ReaderDto(1L, "Name1", "Surname1", LocalDate.of(2021, 9, 1), null, "email1", "address1", 123456789, Status.ACTIVE));
//        readerDtoList.add(new ReaderDto(2L, "Name2", "Surname2", LocalDate.of(2021, 9, 2), null, "email2", "address2", 234567890, Status.ACTIVE));
//        when(readerFacade.showAllReaders()).thenReturn(readerDtoList);
//
//        //When & Then
////        mockMvc.perform(get("/v1/reader/all")
//
//        mockMvc.perform(formLogin("/v1/reader/all").user("admin").password(applicationSecurityConfig.getPasswordEncoder().encode("admin"))
//
////                        .with(SecurityMockMvcRequestPostProcessors.user("admin").password(realApplicationDaoService.getPasswordEncoder().encode("admin")))
//                .acceptMediaType(MediaType.APPLICATION_JSON)
//                )
//
////                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("Adam Nowak", realApplicationDaoService.getPasswordEncoder().encode("password2")))
////                        .contentType(MediaType.APPLICATION_JSON)
////                )
//                .andExpect(status().is(200))
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].id", is(1)))
//                .andExpect(jsonPath("$[1].id", is(2)))
//                .andExpect(jsonPath("$[0].readerName", is("Name1")))
//                .andExpect(jsonPath("$[1].readerName", is("Name2")))
//                .andExpect(jsonPath("$[0].readerSurname", is("Surname1")))
//                .andExpect(jsonPath("$[1].readerSurname", is("Surname2")))
//                .andExpect(jsonPath("$[0].accountFrom", is("2021-09-01")))
//                .andExpect(jsonPath("$[1].accountFrom", is("2021-09-02")))
//                .andExpect(jsonPath("$[0].accountTo", emptyOrNullString()))
//                .andExpect(jsonPath("$[1].accountTo", emptyOrNullString()))
//                .andExpect(jsonPath("$[0].readerEmail", is("email1")))
//                .andExpect(jsonPath("$[1].readerEmail", is("email2")))
//                .andExpect(jsonPath("$[0].readerAddress", is("address1")))
//                .andExpect(jsonPath("$[1].readerAddress", is("address2")))
//                .andExpect(jsonPath("$[0].readerPhoneNumber", is(123456789)))
//                .andExpect(jsonPath("$[1].readerPhoneNumber", is(234567890)))
//                .andExpect(jsonPath("$[0].status", is("ACTIVE")))
//                .andExpect(jsonPath("$[1].status", is("ACTIVE")));
//    }
//
//    @Test
//    void testShouldFindReaderBySurname() throws Exception {
//
//        //Given
//        List<ReaderDto> readerDtoList = new ArrayList<>();
//        readerDtoList.add(new ReaderDto(1L, "Name1", "Surname1", LocalDate.of(2021, 9, 1), null, "email1", "address1", 123456789, Status.ACTIVE));
//        readerDtoList.add(new ReaderDto(2L, "Name2", "Surname1", LocalDate.of(2021, 9, 2), null, "email2", "address2", 234567890, Status.ACTIVE));
//        when(readerFacade.showReaderBySurname("Surname1")).thenReturn(readerDtoList);
//
//        //When & Then
//        mockMvc.perform(get("/v1/reader/surname?readerSurname=Surname1")
//                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("Adam Nowak", "password2"))
//                        .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andExpect(status().is(200))
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].id", is(1)))
//                .andExpect(jsonPath("$[1].id", is(2)))
//                .andExpect(jsonPath("$[0].readerName", is("Name1")))
//                .andExpect(jsonPath("$[1].readerName", is("Name2")))
//                .andExpect(jsonPath("$[0].readerSurname", is("Surname1")))
//                .andExpect(jsonPath("$[1].readerSurname", is("Surname1")))
//                .andExpect(jsonPath("$[0].accountFrom", is("2021-09-01")))
//                .andExpect(jsonPath("$[1].accountFrom", is("2021-09-02")))
//                .andExpect(jsonPath("$[0].accountTo", emptyOrNullString()))
//                .andExpect(jsonPath("$[1].accountTo", emptyOrNullString()))
//                .andExpect(jsonPath("$[0].readerEmail", is("email1")))
//                .andExpect(jsonPath("$[1].readerEmail", is("email2")))
//                .andExpect(jsonPath("$[0].readerAddress", is("address1")))
//                .andExpect(jsonPath("$[1].readerAddress", is("address2")))
//                .andExpect(jsonPath("$[0].readerPhoneNumber", is(123456789)))
//                .andExpect(jsonPath("$[1].readerPhoneNumber", is(234567890)))
//                .andExpect(jsonPath("$[0].status", is("ACTIVE")))
//                .andExpect(jsonPath("$[1].status", is("ACTIVE")));
//    }
//
//    @Test
//    void testShouldFindReaderById() throws Exception {
//
//        //Given
//        Optional<Reader> reader = Optional.of(new Reader(1L, "Name1", "Surname1", LocalDate.of(2021, 9, 1), null, "email1", "address1", 123456789, Status.ACTIVE));
//        when(readerFacade.showReaderById(1L)).thenReturn(reader);
//
//        //When & Then
//        mockMvc.perform(get("/v1/reader/1")
//                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("Adam Nowak", "password2"))
//                        .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andExpect(status().is(200))
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.readerName", is("Name1")))
//                .andExpect(jsonPath("$.readerSurname", is("Surname1")))
//                .andExpect(jsonPath("$.accountFrom", is("2021-09-01")))
//                .andExpect(jsonPath("$.accountTo", emptyOrNullString()))
//                .andExpect(jsonPath("$.readerEmail", is("email1")))
//                .andExpect(jsonPath("$.readerAddress", is("address1")))
//                .andExpect(jsonPath("$.readerPhoneNumber", is(123456789)))
//                .andExpect(jsonPath("$.status", is("ACTIVE")));
//    }
//
//}
//
