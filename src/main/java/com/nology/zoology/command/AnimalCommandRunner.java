package com.nology.zoology.command;

import com.nology.zoology.animal.Animal;
import com.nology.zoology.animal.AnimalSorting;
import com.nology.zoology.animal.SortByStarsThenName;
import com.nology.zoology.user.UserType;
import com.nology.zoology.zoo.Zoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimalCommandRunner extends CommandRunner {

    private Zoo zoo;
    private UserType userType;

    private static final String[] ANIMAL_COMMANDS = {
        "List all animals",
        "List animals by type",
        "List animals by stars",
        "Visit an animal",
        "Exit"
    };

    public AnimalCommandRunner(Zoo zoo, UserType userType) {
        super(ANIMAL_COMMANDS, "Animal");
        this.zoo = zoo;
        this.userType = userType;
    }

    protected void listAllAnimals() {
        printMessage("All animals in the zoo:");
        List<Animal> zooAnimals = this.zoo.getAnimals(AnimalSorting.byId);
        for (Animal zooAnimal : zooAnimals) {
            System.out.println(zooAnimal.getInformation());
        }
    }

    protected void listAllAnimalsByType() {
        printMessage("All animals in the zoo:");
        List<Animal> zooAnimals = this.zoo.getAnimals(AnimalSorting.byType);
        for (Animal zooAnimal : zooAnimals) {
            System.out.println(zooAnimal.getInformation());
        }
    }

    protected void listAllAnimalsByStars() {
        printMessage("All animals in the zoo:");
        List<Animal> zooAnimals = new ArrayList<>( this.zoo.getAnimals(AnimalSorting.byType) );
        Collections.sort( zooAnimals, new SortByStarsThenName() );
        for (Animal zooAnimal : zooAnimals) {
            System.out.println(zooAnimal.getInformation());
        }
    }

    protected void runSingleAnimalCommands() {
        SingleAnimalCommandRunner commandRunner = null;
        switch (userType) {
            case visitor:
                commandRunner = new VisitorSingleAnimalCommandRunner(zoo, null);
                break;
            case zooKeeper:
                commandRunner = new ZooKeeperSingleAnimalCommandRunner(zoo, null);
                break;
        }
        commandRunner.runCommands();
    }

    @Override
    protected void beforeCommands() {
        // do nothing
    }

    @Override
    protected HandleUserSelection handleUserSelection(int userSelection) {
        if( userSelection == ANIMAL_COMMANDS.length ) {
            return HandleUserSelection.doBreak;
        }

        System.out.println("Performing user selection " + userSelection);
        switch (userSelection) {
            case 1:
                listAllAnimals();
                break;
            case 2:
                listAllAnimalsByType();
                break;
            case 3:
                listAllAnimalsByStars();
                break;
            case 4:
                runSingleAnimalCommands();
                break;
        }

        return HandleUserSelection.moreCommands;
    }

    @Override
    protected void performExit() {
        this.zoo.stopThreads();
        super.performExit();
    }
}
