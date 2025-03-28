package com.library.bookmanagement.model;

//import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// // Enum which helps usto restrict availability values
// enum AvailabilityStatus {
//     AVAILABLE, CHECKED_OUT
// }

@Entity // this helps to make this class as JPA Entity so we can include in table format in sql db
@Table(name="books") // maps this entity to database table name books 
// this is use for table name customization 
@Data // this is the lombok functionality used for defing setter and getter 
@AllArgsConstructor // for all argument constructor as @data has @Required args constructor
@NoArgsConstructor // as customizede constructor is defined so empty constructor is not there so need to define
public class Book {
    @Id // marke this as primary key in books table
    @GeneratedValue 
    // auto generateds the id value
    private Long id;
  
    @NotNull // it ensures that the title is not null and it checks for validation too 
    @Column(nullable = false) // Ensures title is not null at the database level
    private String title;

    // ensure author is not null at server level
    @Column(nullable = false) // Ensures title is not null at the database level
    private String author;

    //@Column("Genre") // can use column annotation for customize table name 
    // else the table name would be same as variable name;
    private String genre;

    @NotNull // ensure no null 
    @Enumerated(EnumType.STRING) // to store as a string in the database
    private AvailabilityStatus availability;

    // we can use use getetrs and setters manually but lombok helps us to manage that 
    /*
     *  public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }
     */
}
