package com.example.dogs;

public class DogNotFoundException extends RuntimeException {

    public DogNotFoundException(long id) {
        super("Could not find dog " + id);
    }

}
