package com.example.dogs.controllers;

import com.example.dogs.DogNotFoundException;
import com.example.dogs.model.Dog;
import com.example.dogs.model.DogsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogsController {

    private final DogsRepository repository;

    DogsController(DogsRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/dogs")
    List<Dog> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/dogs")
    Dog newDog(@RequestBody Dog newDog) {
        return repository.save(newDog);
    }

    // Single item
    @GetMapping("/dogs/{id}")
    Dog one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new DogNotFoundException(id));
    }

    @PutMapping("/dogs/{id}")
    Dog replaceDog(@RequestBody Dog newDog, @PathVariable Long id) {
        return repository.findById(id)
                .map(dog -> {
                    dog.setName(dog.getName());
                    dog.setBread(dog.getBread());
                    dog.setColor(dog.getColor());
                    dog.setAge(dog.getAge());
                    return repository.save(dog);
                })
                .orElseGet(() -> {
                    return repository.save(newDog);
                });
    }

    @DeleteMapping("/dog/{id}")
    void deleteDog(@PathVariable Long id) {
        repository.deleteById(id);
    }
}