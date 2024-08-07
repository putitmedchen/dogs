package com.example.dogs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DogNotFoundAdvice {

    @ExceptionHandler(DogNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String DogNotFoundHandler(DogNotFoundException ex) {
        return ex.getMessage();
    }

}
