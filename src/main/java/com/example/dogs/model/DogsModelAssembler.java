package com.example.dogs.model;

import com.example.dogs.controllers.DogsController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DogsModelAssembler implements RepresentationModelAssembler<Dog, EntityModel<Dog>> {

        @Override
        public EntityModel<Dog> toModel(Dog dog) {

            return EntityModel.of(dog, //
                    linkTo(methodOn(DogsController.class).one(dog.getId())).withSelfRel(),
                    linkTo(methodOn(DogsController.class).all()).withRel("dogs"));
    }
}
