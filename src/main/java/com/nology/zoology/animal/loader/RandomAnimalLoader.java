package com.nology.zoology.animal.loader;

import com.nology.zoology.animal.Animal;
import com.nology.zoology.animal.AnimalFactory;
import com.nology.zoology.animal.AnimalType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAnimalLoader implements AnimalLoader {

    private static final Random RANDOM = new Random();

    private AnimalFactory animalFactory = new AnimalFactory();
    private int numberOfAnimals = 20;

    @Override
    public List<Animal> loadAnimals() {
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < numberOfAnimals; i++) {
            switch (RANDOM.nextInt(4)) {
                case 0:
                    animals.add(animalFactory.createAnimal(AnimalType.tiger));
                    break;
                case 1:
                    animals.add(animalFactory.createAnimal(AnimalType.llama));
                    break;
                case 2:
                    animals.add(animalFactory.createAnimal(AnimalType.crocodile));
                    break;
                case 3:
                    animals.add(animalFactory.createAnimal(AnimalType.lion));
                    break;
            }
        }
        return animals;
    }

}
