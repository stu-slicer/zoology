package com.nology;

import com.nology.zoology.animal.*;
import com.nology.zoology.zoo.Zoo;
import com.nology.zoology.zoo.ZooFactory;

import java.util.List;
import java.util.Random;

public class ZooPlayground {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        Tiger tiger = new Tiger(AnimalUtils.nextUniqueId(), AnimalUtils.generateName(), AnimalUtils.generateAge());
        System.out.println("Tiger " + tiger.getName() + " is " + tiger.getAge() + " years old");
        System.out.println(tiger);

        Zoo zoo = ZooFactory.getOrCreateZoo();

        AnimalFactory animalFactory = new AnimalFactory();
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
            switch (RANDOM.nextInt(4)) {
                case 0:
                    zoo.addAnimal(animalFactory.createAnimal(AnimalType.tiger));
                    break;
                case 1:
                    zoo.addAnimal(animalFactory.createAnimal(AnimalType.llama));
                    break;
                case 2:
                    zoo.addAnimal(animalFactory.createAnimal(AnimalType.crocodile));
                    break;
                case 3:
                    zoo.addAnimal(animalFactory.createAnimal(AnimalType.lion));
                    break;
            }
        }

        System.out.println( zoo.getAnimalCount() );

        zoo.listAnimals( AnimalSorting.byType );

        List<Animal> found = zoo.findAnimalsByName("fluffy");
        System.out.println(found);
    }



}
