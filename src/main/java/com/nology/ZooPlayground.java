package com.nology;

import com.nology.zoology.animal.*;
import com.nology.zoology.zoo.Zoo;
import com.nology.zoology.zoo.ZooFactory;

import java.util.Random;

import static com.nology.zoology.animal.AnimalUtils.*;

public class ZooPlayground {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        Tiger tiger = new Tiger(nextUniqueId(), generateName(), generateAge());
        System.out.println("Tiger " + tiger.getName() + " is " + tiger.getAge() + " years old");
        System.out.println(tiger);

        Zoo zoo = ZooFactory.getOrCreateZoo();
        Zoo zoo2 = ZooFactory.getOrCreateZoo();
        Zoo zoo3 = ZooFactory.getOrCreateZoo();
        Zoo zoo4 = zoo;

        if( zoo == zoo2 && zoo2 == zoo3 ) {
            System.out.println("They are the same!");
        }

        // three tigers
        for (int i = 0; i < 3; i++) {
            zoo.addAnimal(new Tiger( nextUniqueId(), generateName(), generateAge() ));
        }
        // five llamas
        for (int i = 0; i < 5; i++) {
            zoo2.addAnimal(new Llama( nextUniqueId(), generateName(), generateAge() ));
        }
        // 2 crocodiles
        for (int i = 0; i < 5; i++) {
            zoo3.addAnimal(new Crocodile( nextUniqueId(), generateName(), generateAge() ));
        }

        // or random!
        for (int i = 0; i < 10; i++) {
            switch (RANDOM.nextInt(3)) {
                case 0:
                    zoo4.addAnimal(new Tiger( nextUniqueId(), generateName(), generateAge() ));
                    break;
                case 1:
                    zoo2.addAnimal(new Llama( nextUniqueId(), generateName(), generateAge() ));
                    break;
                case 2:
                    zoo3.addAnimal(new Crocodile( nextUniqueId(), generateName(), generateAge() ));
                    break;
            }
        }

        System.out.println( zoo.getAnimalCount() );
        
        Math.max(2,3 );
    }



}
