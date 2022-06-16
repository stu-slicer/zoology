package com.nology;

import com.nology.zoology.animal.*;
import com.nology.zoology.zoo.RandomAnimalLoader;
import com.nology.zoology.zoo.Zoo;

import java.util.List;
import java.util.Random;

public class ZooPlayground {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        Zoo zoo = new Zoo(new RandomAnimalLoader());

        System.out.println( zoo.getAnimalCount() );

        zoo.listAnimals( AnimalSorting.byType );

        List<Animal> found = zoo.findAnimalsByName("fluffy");
        System.out.println(found);

    }

}
