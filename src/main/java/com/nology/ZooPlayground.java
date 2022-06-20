package com.nology;

import com.nology.zoology.animal.loader.CSVAnimalLoader;
import com.nology.zoology.animal.loader.RandomAnimalLoader;
import com.nology.zoology.user.UserType;
import com.nology.zoology.user.command.AnimalCommandRunner;
import com.nology.zoology.user.command.SingleAnimalCommandRunner;
import com.nology.zoology.user.command.UserCommandRunner;
import com.nology.zoology.user.command.ZooKeeperSingleAnimalCommandRunner;
import com.nology.zoology.zoo.Zoo;

import java.util.Random;

public class ZooPlayground {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        RandomAnimalLoader randomAnimalLoader = new RandomAnimalLoader();
        CSVAnimalLoader csvAnimalLoader = new CSVAnimalLoader("src/main/resources/animals-to-load.csv");

        Zoo zoo = new Zoo( randomAnimalLoader );

        System.out.println( zoo.getAnimalCount() );

        UserCommandRunner userCommandRunner = new UserCommandRunner(zoo);
        AnimalCommandRunner commandRunner = new AnimalCommandRunner(zoo, UserType.visitor);
        AnimalCommandRunner zooKeepeCcommandRunner = new AnimalCommandRunner(zoo, UserType.zooKeeper);
        SingleAnimalCommandRunner singleAnimalCommandRunner = new ZooKeeperSingleAnimalCommandRunner(zoo, null);

        userCommandRunner.runCommands();

    }

}
