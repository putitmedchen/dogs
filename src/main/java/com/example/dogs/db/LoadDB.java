package com.example.dogs.db;

import com.example.dogs.model.Bread;
import com.example.dogs.model.Color;
import com.example.dogs.model.Dog;
import com.example.dogs.model.DogsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDB {

    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);

    @Bean
    CommandLineRunner initDatabase(DogsRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Dog("Beta", Bread.SHEPHERD, com.example.dogs.model.Color.WHITE, 2)));
            log.info("Preloading " + repository.save(new Dog("Frodo", Bread.BORDER_COLLIE, Color.WHITE_BLACK, 7)));
            log.info("Preloading " + repository.save(new Dog("Casper", Bread.COLLIE, Color.BLACK, 7)));
        };
    }
}
