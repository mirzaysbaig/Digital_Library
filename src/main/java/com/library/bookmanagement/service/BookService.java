package com.library.bookmanagement.service;

import java.util.List;

import com.library.bookmanagement.model.Book;

public interface BookService {
    // fetching all books from the library 
    // @return List of all books 
    List<Book> getAllBooks();

    /*  finding a book by its id
     * @param parameter input book id 
     * @return Optional for handling null values 
     * // nbut ewe will throw exception 
     */
    Book getBookById(Long id);

    // finding book by title , input parameter title of book 
    Book getBookByTitle(String title);

    // adding a new book to the library 
    // parameter book to bee added , 
    // return ing the saved book 
    Book addBook(Book book);

    // updating book detais and return updated book 
    Book updateBook(Long id, Book updatedBook);

    // delete book giving the id of the book 
    void deleteBook(Long id);
   
}
