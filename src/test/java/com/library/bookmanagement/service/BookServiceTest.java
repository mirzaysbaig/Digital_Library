package com.library.bookmanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.library.bookmanagement.model.AvailabilityStatus;
import com.library.bookmanagement.model.Book;
import com.library.bookmanagement.repository.BookRepository;

//@SpringBootTest
@DirtiesContext
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
     
    // creating mock  and just like autowirin gthe dependency 
    @Mock
    private BookRepository bookRepository; // Mocked BookRepository dependency

    @InjectMocks
    private BookServiceImpl bookService; // Inject mocks into BookServiceImpl instance

    private Book book; // Book instance used in tests

    @BeforeEach
    void setUp() {
        // Initialize mock objects and sample book instance before each test
        MockitoAnnotations.openMocks(this);
        book = new Book(1L, "Spring Boot Guide", "John Doe", "Technology", AvailabilityStatus.AVAILABLE);
    }

    @Test
    void testFindBookById() {
        // Mocking repository response to check evenmy dependency fails 
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        // Calling service method
        Book foundBook = bookService.getBookById(1L);

        // Assertions to check the unit tes cases 
        assertNotNull(foundBook);
        // return true if it matches 
        assertEquals("Spring Boot Guide", foundBook.getTitle());
    }
}
