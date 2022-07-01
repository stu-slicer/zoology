package com.nology.zoology.controller;

import com.nology.zoology.animal.Animal;
import com.nology.zoology.animal.AnimalSorting;
import com.nology.zoology.zoo.Zoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.event.AncestorEvent;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/zoology")
public class ZooRestController {

    @Autowired
    private Zoo zoo;

    // GET animals
    // GET /zoology/v1/animals
    @GetMapping("/animals")
    public ResponseEntity<List<Animal>> getAllAnimals() {
        List<Animal> animals = zoo.getAnimals(AnimalSorting.byId);
        return ResponseEntity.status(HttpStatus.OK).body( animals );
    }

    // GET animals
    // GET /zoology/v1/animal/123

    // PUT /zoology/v1/animal/123/feed
    @PutMapping("/animal/{id}/feed")
    public ResponseEntity<Integer> feedAnimal(@PathVariable int id) {
        Optional<Animal> animalById = this.zoo.findAnimalById(id);
        animalById.ifPresent(animal -> {
            animal.pet();
        });
        if( animalById.isPresent() ) {
            animalById.get().feed();
        }
        return ResponseEntity.status( HttpStatus.OK )
                .body( (int) animalById.map( Animal::getHunger ).orElse((short) 0 ));
    }

    // PUT /zoology/v1/animal/123/pet
    @PutMapping("/animal/{id}/pet")
    public ResponseEntity<Boolean> petAnimal(@PathVariable int id) {
        Optional<Animal> animalById = this.zoo.findAnimalById(id);
        animalById.ifPresent(animal -> {
            animal.pet();
        });
        return ResponseEntity.status( HttpStatus.OK )
                .body( animalById.map( Animal::isPettable ).orElse(false));
    }

    // PUT /zoology/v1/animal/123/visit

    // PUT /zoology/v1/animal/123/give-star
    @PutMapping("/animal/{id}/give-star")
    public ResponseEntity<Integer> giveStarToAnimal(@PathVariable int id) {
        Optional<Animal> animalById = this.zoo.findAnimalById(id);
        animalById.ifPresent(animal -> {
            animal.receiveStar(1);
        });
        return ResponseEntity.status( HttpStatus.OK )
                .body( animalById.map( Animal::getStars ).orElse(0));
    }


}
