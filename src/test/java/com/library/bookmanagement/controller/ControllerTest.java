package com.library.bookmanagement.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.bookmanagement.BookManagementApplication;
import com.library.bookmanagement.model.AvailabilityStatus;
import com.library.bookmanagement.model.Book;
import com.library.bookmanagement.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

// it means that for this test to run we need to start the spring boot server 
// it shows go to class mention and start the main application 
@SpringBootTest // it refers to which classes to go for testing 
//mockito setting is done to define the strictness of it 
// if the mock has not called then mockito will say that we have mock but it is not called then we need to fix it 
//@MockitoSettings(strictness = Strictness.STRICT_STUBS) 
//it mimics mvc and creaate a mockk of it 
@AutoConfigureMockMvc 
// one spring test is executed then it will kill the server with @dities context
// as one server will start it doesnt kill the teest 
@DirtiesContext 
// we also have configuration of main class 
@ActiveProfiles("test") 
//@ExtendWith(MockitoExtension.class)
public class ControllerTest {
    
    //MockMvc is a part of Spring Test framework that allows testing Spring MVC controllers
  // without running a full web server.
  
  @Autowired
  private MockMvc mockMvc; // MockMvc instance for performing HTTP requests in tests
   // it is just like autowired to mock a spring bmanaged bean or use as a mock to manage the bean dependency in spring 
  @MockBean
  private BookService bookService;

  // to inject the mocked dependencies 
  @InjectMocks
  private BookController bookController;
  
  private Book book;
  @BeforeEach
  void setUP(){
    //objectMapper = new ObjectMapper(); // ObjectMapper for JSON conversion

    // Initialize a sample book object before each test
    book = new Book(1L, "Spring Boot Guide", "John Doe", "Technology",AvailabilityStatus.AVAILABLE);

    }

    @Test
    public void invalidBookIdResultsInBadHttpRequest() throws Exception {
        // uri for Query 
        // URI uri = UriComponentsBuilder
        //     .fromPath("/books")
        //     .queryParam("id", "-1") // Invalid book ID test 
        //     .build().toUri();

        // for path 
       
        String uri = "/books/{id}"; 
        // Perform GET request with invalid book ID
        MockHttpServletResponse response = mockMvc.perform(
            get(uri, -1)  // Pass -1 as the path variable value
            .accept(MediaType.APPLICATION_JSON)
    ).andReturn().getResponse();

        // Expecting  HTTP 400 Bad Request
        // System.out.println("response"+response.getStatus());
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
        // // assertEquals(500, response.getStatus());
    }


    @Test
    void testGetAllBooks() throws Exception {
        // Arrange: Create a list with one book and mock the service method
        List<Book> books = Arrays.asList(book);
        when(bookService.getAllBooks()).thenReturn(books);

        // Act & Assert: Perform a GET request and verify the response
        mockMvc.perform(get("/books"))
               .andExpect(status().isOk()) // Expect HTTP 200 OK
               .andExpect(jsonPath("$.size()").value(1)); // Expect one book in response

        verify(bookService, times(1)).getAllBooks(); // Verify service method was called once

        // we can also capture using argument captor 
    }

}
