package com.nology;

import com.nology.zoology.animal.*;
import com.nology.zoology.zoo.Zoo;

import java.util.Random;

public class ZooPlayground {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        Tiger tiger = new Tiger(AnimalUtils.nextUniqueId(), AnimalUtils.generateName(), AnimalUtils.generateAge());
        System.out.println("Tiger " + tiger.getName() + " is " + tiger.getAge() + " years old");
        System.out.println(tiger);

        Zoo zoo = new Zoo();
//        // three tigers
//        for (int i = 0; i < 3; i++) {
//            zoo.addAnimal(new Tiger( AnimalUtils.nextUniqueId(), AnimalUtils.generateName(), AnimalUtils.generateAge() ));
//        }
//        // five llamas
//        for (int i = 0; i < 5; i++) {
//            zoo.addAnimal(new Llama( AnimalUtils.nextUniqueId(), AnimalUtils.generateName(), AnimalUtils.generateAge() ));
//        }
//        // 2 crocodiles
//        for (int i = 0; i < 5; i++) {
//            zoo.addAnimal(new Crocodile( AnimalUtils.nextUniqueId(), AnimalUtils.generateName(), AnimalUtils.generateAge() ));
//        }

        // or random!
        for (int i = 0; i < 10; i++) {
            switch (RANDOM.nextInt(3)) {
                case 0:
                    zoo.addAnimal(new Tiger( AnimalUtils.nextUniqueId(), AnimalUtils.generateName(), AnimalUtils.generateAge() ));
                    break;
                case 1:
                    zoo.addAnimal(new Llama( AnimalUtils.nextUniqueId(), AnimalUtils.generateName(), AnimalUtils.generateAge() ));
                    break;
                case 2:
                    zoo.addAnimal(new Crocodile( AnimalUtils.nextUniqueId(), AnimalUtils.generateName(), AnimalUtils.generateAge() ));
                    break;
            }
        }

        System.out.println( zoo.getAnimalCount() );

        zoo.listAnimals();
    }



}
