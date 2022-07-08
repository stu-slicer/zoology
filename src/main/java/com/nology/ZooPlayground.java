package com.nology;

import com.nology.zoology.animal.loader.CSVAnimalLoader;
import com.nology.zoology.animal.loader.RandomAnimalLoader;
import com.nology.zoology.animal.loader.StreamRandomAnimalLoader;
import com.nology.zoology.command.*;
import com.nology.zoology.data.CSVZooDataLoader;
import com.nology.zoology.data.ZooDataLoader;
import com.nology.zoology.user.UserType;
import com.nology.zoology.zoo.Zoo;
import com.nology.zoology.zoo.ZooBuilder;

import java.util.Random;

public class ZooPlayground {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        RandomAnimalLoader randomAnimalLoader = new RandomAnimalLoader();
        StreamRandomAnimalLoader streamRandomAnimalLoader = new StreamRandomAnimalLoader(12);
        CSVAnimalLoader csvAnimalLoader = new CSVAnimalLoader("src/main/resources/animals-to-load.csv");

        ZooDataLoader zooDataLoader = new CSVZooDataLoader( CSVZooDataLoader.DEFAULT_DATA_FILE );

        Zoo zoo = ZooBuilder.create()
                .withAnimalLoader( randomAnimalLoader )
                .withZooDataLoader( zooDataLoader )
                .build();

        System.out.println( zoo.getAnimalCount() );

        UserCommandRunner userCommandRunner = new UserCommandRunner(zoo);
        AnimalCommandRunner keeperAnimalCommandRunner = new ZooKeeperAnimalCommandRunner(zoo, UserType.visitor);
        AnimalCommandRunner visitorAnimalCommandRunner = new VisitorAnimalCommandRunner(zoo, UserType.visitor);
        SingleAnimalCommandRunner singleAnimalCommandRunner = new ZooKeeperSingleAnimalCommandRunner(zoo, null);

        userCommandRunner.runCommands();

    }

}
