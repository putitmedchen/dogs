package com.example.dogs.controllers;

import com.example.dogs.exception.DogNotFoundException;
import com.example.dogs.model.Dog;
import com.example.dogs.model.DogsModelAssembler;
import com.example.dogs.model.DogsRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class DogsController {

    private final DogsRepository repository;
    private final DogsModelAssembler assembler;

    DogsController(DogsRepository repository, DogsModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/dogs")
    public CollectionModel<EntityModel<Dog>> all() {
        List<EntityModel<Dog>> dogs = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(dogs, linkTo(methodOn(DogsController.class).all()).withSelfRel());
    }

    @PostMapping("/dogs")
    Dog newDog(@RequestBody Dog newDog) {
        return repository.save(newDog);
    }

    // Single item
    @GetMapping("/dogs/{id}")
    public EntityModel<Dog> one(@PathVariable Long id) {

        Dog dog = repository.findById(id) //
                .orElseThrow(() -> new DogNotFoundException(id));

        return assembler.toModel(dog);
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