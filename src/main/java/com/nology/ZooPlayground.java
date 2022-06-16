package com.nology;

import com.nology.zoology.animal.*;
import com.nology.zoology.animal.loader.CSVAnimalLoader;
import com.nology.zoology.animal.loader.RandomAnimalLoader;
import com.nology.zoology.zoo.Zoo;

import java.util.List;
import java.util.Random;

public class ZooPlayground {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        RandomAnimalLoader randomAnimalLoader = new RandomAnimalLoader();
        CSVAnimalLoader csvAnimalLoader = new CSVAnimalLoader("src/main/resources/animals-to-load.csv");

        Zoo zoo = new Zoo(csvAnimalLoader);

        System.out.println( zoo.getAnimalCount() );

        zoo.listAnimals( AnimalSorting.byType );

        List<Animal> found = zoo.findAnimalsByName("fluffy");
        System.out.println(found);

        List<Animal> sortedAnimals = zoo.getAnimals(AnimalSorting.byId);
        for (Animal sortedAnimal : sortedAnimals) {
            System.out.println(String.format("%d,%s,%s,%d",
                    sortedAnimal.getId(), sortedAnimal.getType(), sortedAnimal.getName(), sortedAnimal.getAge() ));
        }

    }

}
