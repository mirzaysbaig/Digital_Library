package com.library.bookmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // this is a central exception handler 
public class GlobalExceptionHandler {
      @ExceptionHandler(BookNotFoundException.class) // Specifies handling for BookNotFoundException
    public ResponseEntity<String> handleBookNotFoundException(BookNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage()); // Returns 404 with error message
    }
 //it catches all other unexprected exceptionn
    @ExceptionHandler(Exception.class) // Catches all unhandled exceptions
    public ResponseEntity<String> globalExceptionHandler(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred: " + ex.getMessage()); // Returns 500 error which is internal server error 
    }
}
