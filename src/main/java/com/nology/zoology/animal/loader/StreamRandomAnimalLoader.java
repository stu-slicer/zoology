package com.nology.zoology.animal.loader;

import com.nology.zoology.animal.Animal;
import com.nology.zoology.animal.AnimalFactory;
import com.nology.zoology.animal.AnimalType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * An implementation of {@link AnimalLoader} that uses the {@link Stream} to generate a stream of random animals.
 */
public class StreamRandomAnimalLoader implements AnimalLoader {

    private static final Random RANDOM = new Random();

    private AnimalFactory animalFactory = new AnimalFactory();
    private int numberOfAnimals = 20;

    public StreamRandomAnimalLoader() {
    }
    public StreamRandomAnimalLoader(int numberOfAnimals) {
        this.numberOfAnimals = numberOfAnimals;
    }

    @Override
    public List<Animal> loadAnimals() {
        int limit = AnimalType.values().length;
        return Stream.generate( () -> RANDOM.nextInt(limit))
                .map(this::createAnimal)
                .filter(Objects::nonNull )
                .limit(numberOfAnimals)
                .collect(Collectors.toList());
    }

    /**
     * Create an animal based on {@link AnimalType} ordinal.
     * If the {@link AnimalFactory} doesn't know how to create then don't care!
     * @param ordinal
     * @return
     */
    private Animal createAnimal(int ordinal) {
        try {
            return animalFactory.createAnimal( AnimalType.values()[ordinal] );
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}
