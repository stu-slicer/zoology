package com.nology;

import com.nology.zoology.command.AnimalCommandRunner;
import com.nology.zoology.command.SingleAnimalCommandRunner;
import com.nology.zoology.animal.loader.CSVAnimalLoader;
import com.nology.zoology.animal.loader.RandomAnimalLoader;
import com.nology.zoology.zoo.Zoo;

import java.util.Random;

public class ZooPlayground {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        RandomAnimalLoader randomAnimalLoader = new RandomAnimalLoader();
        CSVAnimalLoader csvAnimalLoader = new CSVAnimalLoader("src/main/resources/animals-to-load.csv");

        Zoo zoo = new Zoo( randomAnimalLoader );

        System.out.println( zoo.getAnimalCount() );

        AnimalCommandRunner commandRunner = new AnimalCommandRunner(zoo);
        SingleAnimalCommandRunner singleAnimalCommandRunner = new SingleAnimalCommandRunner(zoo, null);

        commandRunner.runCommands();

    }

}
