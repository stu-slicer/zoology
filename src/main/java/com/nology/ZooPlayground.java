package com.nology;

import com.nology.zoology.animal.*;
import com.nology.zoology.zoo.Zoo;

import java.util.Random;
import java.util.Scanner;

import static com.nology.zoology.animal.AnimalUtils.*;

public class ZooPlayground {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        Tiger tiger = new Tiger(nextUniqueId(), generateName(), generateAge());
        System.out.println("Tiger " + tiger.getName() + " is " + tiger.getAge() + " years old");
        System.out.println(tiger);

        Zoo zoo = new Zoo();

        // three tigers
        for (int i = 0; i < 3; i++) {
            zoo.addAnimal(new Tiger( nextUniqueId(), generateName(), generateAge() ));
        }
        // five llamas
        for (int i = 0; i < 5; i++) {
            zoo.addAnimal(new Llama( nextUniqueId(), generateName(), generateAge() ));
        }
        // 2 crocodiles
        for (int i = 0; i < 5; i++) {
            zoo.addAnimal(new Crocodile( nextUniqueId(), generateName(), generateAge() ));
        }

        // or random!
        for (int i = 0; i < 10; i++) {
            switch (RANDOM.nextInt(3)) {
                case 0:
                    zoo.addAnimal(new Tiger( nextUniqueId(), generateName(), generateAge() ));
                    break;
                case 1:
                    zoo.addAnimal(new Llama( nextUniqueId(), generateName(), generateAge() ));
                    break;
                case 2:
                    zoo.addAnimal(new Crocodile( nextUniqueId(), generateName(), generateAge() ));
                    break;
            }
        }

        // or user defined!
        Scanner scanner = new Scanner(System.in);

        int numTigers = readInteger(scanner, "How many tigers do you want to create? ", 1, 5);
        int numLLamas = readInteger(scanner, "How many llamas do you want to create? ", 1, 5);
        int numLCrocs = readInteger(scanner, "How many crocodiles do you want to create? ", 1, 5);

        for (int i = 0; i < numTigers; i++) {
            zoo.addAnimal(new Tiger( nextUniqueId(), generateName(), generateAge() ));
        }
        for (int i = 0; i < numLLamas; i++) {
            zoo.addAnimal(new Llama( nextUniqueId(), generateName(), generateAge() ));
        }
        for (int i = 0; i < numLCrocs; i++) {
            zoo.addAnimal(new Crocodile( nextUniqueId(), generateName(), generateAge() ));
        }

        System.out.println( zoo.getAnimalCount() );


    }

    private static int readInteger(Scanner scanner, String prompt, int min, int max) {
        int num = -1;
        while ( num < min || num > max ) {
            System.out.println(prompt);
            num = scanner.nextInt();
            if( num < min || num > max ) {
                System.out.println("Please enter in range of " + min + " and " + max);
            }

        }
        return num;
    }



}
