package com.library.bookmanagement.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {
    private Book book;

    // doing initialisation  
    @BeforeEach
    void setUp() {
        // Initialize a sample book object before each test
        book = new Book(1L, "Spring Boot Guide", "John Doe", "Technology", AvailabilityStatus.AVAILABLE);
    }
   

    // validsation for the creation of book object 
    @Test
    void testBookCreation() {
        // Validate that book object is created successfully
        assertNotNull(book);

        // use of assertion equals when the mapping is same returns true else false 
        assertEquals(1L, book.getId());
        assertEquals("Spring Boot Guide", book.getTitle()); 
        assertEquals("John Doe", book.getAuthor());
        assertEquals("Technology", book.getGenre());
        assertEquals(AvailabilityStatus.AVAILABLE, book.getAvailability());

    }

    @Test  // now validating enum values 
    void testAvailabilityStatusEnum() {
        // Validate enum values
        assertEquals(AvailabilityStatus.AVAILABLE, AvailabilityStatus.valueOf("AVAILABLE"));
        assertEquals(AvailabilityStatus.CHECKED_OUT, AvailabilityStatus.valueOf("CHECKED_OUT"));
    }
}
