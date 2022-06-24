package com.nology;

import com.nology.zoology.animal.*;
import com.nology.zoology.zoo.Zoo;

import java.util.Random;

public class ZooPlayground {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        int nextId = 0;

        Tiger tiger = new Tiger( nextId++, "Tony " + nextId, RANDOM.nextInt(10) + 2);
        System.out.println("Tiger " + tiger.getName() + " is " + tiger.getAge() + " years old");
        System.out.println(tiger);

        Zoo zoo = new Zoo();

        zoo.addAnimal( new Tiger( nextId++,"Terry", RANDOM.nextInt(10) + 2 ) );
        zoo.addAnimal( new Tiger( nextId++,"Cuddles", RANDOM.nextInt(10) + 2 ) );
        zoo.addAnimal( new Llama( nextId++, "Larry", RANDOM.nextInt(10) + 2 ));
        zoo.addAnimal( new Llama( nextId++, "Legs", RANDOM.nextInt(10) + 2 ));
        zoo.addAnimal( new Crocodile( nextId++, "Carol", RANDOM.nextInt(10) + 2 ));
        zoo.addAnimal( new Crocodile( nextId++, "Snappy", RANDOM.nextInt(10) + 2 ));

        System.out.println( zoo.getAnimalCount() );
    }



}
