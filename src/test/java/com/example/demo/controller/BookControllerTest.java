/*package com.example.demo.controller;

import com.example.demo.dto.BookDTO;
import com.example.demo.entity.BookEntity;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class BookControllerTest {

    private BookController bookController;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        bookController = mock(BookController.class);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void givenBook_whenCreateBookAndBookNotCreated_then200Ok() throws Exception {
        when(bookController.createBook(any(BookEntity.class))).thenReturn(ResponseEntity.ok(givenBookEntity()));
        mockMvc.perform(post("/books/").content(asJsonString(givenBookEntity()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(7L))
                .andExpect(jsonPath("$.title").value("book"))
                .andExpect(jsonPath("$.author").value("Ivan Petrov"))
                .andExpect(jsonPath("$.year").value(2000))
                .andExpect(jsonPath("$.pageQuantity").value(88))
                .andExpect(jsonPath("$.description").value("book"))
                .andExpect(jsonPath("$.publisher").value("publisher"))
                .andReturn();



    }


    private BookEntity givenBookEntity(){
        BookEntity book = new BookEntity();
        book.setAuthor("Ivan Petrov");
        book.setTitle("book");
        book.setYear(2000);
        book.setPageQuantity(88);
        book.setDescription("book");
        book.setPublisher("publisher");
        book.setId(Long.parseLong("1"));
        return book;
    }

    private BookDTO givenBookDTO(){
        BookDTO book = new BookDTO();
        book.setAuthor(null);
        book.setTitle(null);
        book.setYear(null);
        book.setPageQuantity(188);
        book.setDescription(null);
        book.setPublisher("publisher1");
        book.setId(Long.parseLong("1"));
        return book;
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
*/