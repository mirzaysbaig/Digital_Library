package com.library.bookmanagement.exception;
//  effective handling of exception if book not found 
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message){
        super(message);
    }
}
