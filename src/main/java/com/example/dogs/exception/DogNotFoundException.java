package com.example.dogs.exception;

public class DogNotFoundException extends RuntimeException {

    public DogNotFoundException(long id) {
        super("Could not find dog " + id);
    }

}
