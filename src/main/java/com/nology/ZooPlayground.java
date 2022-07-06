package com.nology;

import com.nology.zoology.animal.*;
import com.nology.zoology.animal.loader.CSVAnimalLoader;
import com.nology.zoology.animal.loader.RandomAnimalLoader;
import com.nology.zoology.zoo.Zoo;
import com.nology.zoology.zoo.ZooBuilder;
import com.nology.zoology.zoo.ZooFactory;

import java.util.List;
import java.util.Random;

public class ZooPlayground {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        RandomAnimalLoader randomAnimalLoader = new RandomAnimalLoader();
        CSVAnimalLoader csvAnimalLoader = new CSVAnimalLoader("src/main/resources/animals-to-load.csv");

        Zoo zoo = ZooBuilder.create()
                .withAnimalLoader(csvAnimalLoader)
                .build();

        System.out.println( zoo.getAnimalCount() );

        zoo.listAnimals( AnimalSorting.byType );

        List<Animal> found = zoo.findAnimalsByName("fluffy");
        System.out.println(found);

        for (Animal sortedAnimal : zoo.getAnimals(AnimalSorting.byId)) {
            System.out.printf("%d,%s,%s,%d%n",
                    sortedAnimal.getId(), sortedAnimal.getType(), sortedAnimal.getName(), sortedAnimal.getAge() );
        }

    }

}
