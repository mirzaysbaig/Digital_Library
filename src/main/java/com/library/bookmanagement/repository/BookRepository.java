package com.library.bookmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.bookmanagement.model.Book;
 // also known as data Acess layer 
// interface as spring data helps us to create custom repo interface 
// which extends JpA repository which extends Crud repository 
// CRud repository has inbuilt function to manage database 

@Repository // it Marks as a Spring Data JPA repository
// Book is entity and Long is ID type 
public interface BookRepository extends JpaRepository<Book,Long> {
    // Custom query method to find a book by title
    // it uses as select where Title = parameter input
    // for accepting null values too 
    Optional<Book> findByTitle(String title);
}
