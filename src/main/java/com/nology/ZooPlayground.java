package com.nology;

import com.nology.zoology.animal.*;
import com.nology.zoology.zoo.Zoo;

import java.util.Random;

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

        System.out.println( zoo.getAnimalCount() );

    }



}
