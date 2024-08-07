package com.example.dogs.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DogsRepository extends JpaRepository<Dog, Long> {


}
