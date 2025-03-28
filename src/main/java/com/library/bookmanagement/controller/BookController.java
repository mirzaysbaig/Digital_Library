package com.library.bookmanagement.controller;

import java.util.List;
import jakarta.validation.Valid; // ✅ Correct import

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.bookmanagement.exception.BookNotFoundException;
import com.library.bookmanagement.model.Book;
import com.library.bookmanagement.service.BookService;

@RestController  // it marks the class as a Rest Api Controller 
// it is made of @responsebody and @controller class 
@RequestMapping("/books") // used to make the prefix of api, setiing the base URL paths 
public class BookController {

    @Autowired // injecting the spring manage bean Service 
    private BookService bookService; // injecting BookService dependency 

    @GetMapping // handles https request for /books path 
    // fethes all books from the library 
      public List<Book> getAllBooks() {
        return bookService.getAllBooks(); // Calls service to fetch all books
    }


    @GetMapping("/{id}") // Handles GET requests for "books gave as id "
    public Book getBookById(@PathVariable("id") Long id) { // @PathVariable extracts {id} from the URL
        if(id<1){
             throw new BookNotFoundException("ID Should be greater than 1");
           
        }
        return bookService.getBookById(id); // Calls service to fetch book by ID
    }

    // it fetches book using title 
     @GetMapping("/title/{title}") // Handles GET requests for "/books/title/{title}"
    public ResponseEntity<Book> getBookByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(bookService.getBookByTitle(title)); // Returns book details with HTTP 200 (OK)
    }


    // use to add the book and retirn the response entity status 
    @PostMapping // Handles HTTP POST requests for "/books"
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) { // @Valid ensures the book data is validated
        return ResponseEntity.ok(bookService.addBook(book)); // Returns the created book with HTTP 200 (OK)
    }

    // to update the bok details 
    @PutMapping("/{id}") // Handles HTTP PUT requests for "/books/{id}"
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @Valid @RequestBody Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book)); // Updates and returns the modified book
    }

    // to delte the file from library and return the success message 
    @DeleteMapping("/{id}") // Handles HTTP DELETE requests for "/books/{id}"
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id); // Calls service method to delete the book
        return ResponseEntity.noContent().build(); // Returns HTTP 204 (No Content) if deletion is successful
    }

}
