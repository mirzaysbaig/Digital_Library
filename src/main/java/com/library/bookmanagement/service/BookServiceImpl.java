package com.library.bookmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.bookmanagement.exception.BookNotFoundException;
import com.library.bookmanagement.model.Book;
import com.library.bookmanagement.repository.BookRepository;

@Service // marks this class as a service component which is spring handled bean
public class BookServiceImpl implements BookService{

    @Autowired // it helps to inject the Book Repository dependency 
    // automatically which is handled by spring bean 
    private BookRepository bookRepository;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll(); // Fetches all books from the database
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)  // handling null values too 
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found!"));
                 // use of java 8 features 
                // wraps to get the book if not found then return customize exception
    }

    @Override  // fetches the book by title if not fund throw exception
    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title)
        .orElseThrow(() -> new BookNotFoundException("Book with title '" + title + "' not found!"));

    }

    @Override // add BOOk and return it 
    public Book addBook(Book book) {
        // use save function from spring data crud repo 
        return bookRepository.save(book);
    }

    @Override   // use to update the book which is alread stored 
    // first fetch that than update 
    public Book updateBook(Long id, Book updatedBook) {
        
        Book book=getBookById(id);
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setGenre(updatedBook.getGenre());
        book.setAvailability(updatedBook.getAvailability());
        return bookRepository.save(book);
    
    }

    @Override // to delete the book from repo by id
    // first fetching book by id the delete using deleyte fun 
    public void deleteBook(Long id) {
        Book book=getBookById(id);
        bookRepository.delete(book);
    }
    
}
