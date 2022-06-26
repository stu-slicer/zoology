package com.nology.zoology.command;

import com.nology.zoology.animal.Animal;
import com.nology.zoology.animal.AnimalSorting;
import com.nology.zoology.animal.SortByStarsThenName;
import com.nology.zoology.user.UserType;
import com.nology.zoology.zoo.Zoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AnimalCommandRunner extends CommandRunner {

    protected Zoo zoo;
    protected UserType userType;

    public AnimalCommandRunner(String[] commands, Zoo zoo, UserType userType) {
        super(commands, "Animal");
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

    protected void listMostPopularAnimals() {
        printMessage("Most popular animals in the zoo:");
        for (Animal zooAnimal : this.zoo.getMostPopularAnimals(10)) {
            System.out.println(zooAnimal.getInformation());
        }
    }

    protected void listHungriestAnimals() {
        printMessage("Hungriest animals in the zoo:");
        for (Animal zooAnimal : this.zoo.getHungeriestAniamls(40)) {
            System.out.println(zooAnimal.getInformation());
        }
    }

    protected void feedHungriestAnimals() {
        printMessage("Hungriest animals in the zoo:");
        List<Animal> hungeriestAniamls = this.zoo.getHungeriestAniamls(40);
        for (Animal zooAnimal : hungeriestAniamls) {
            zooAnimal.feed();
        }
        printMessage(String.format("Fed %d animals!", hungeriestAniamls.size()));
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
        if( userSelection == this.commands.length ) {
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
                listMostPopularAnimals();
                break;
            case 5:
                runSingleAnimalCommands();
                break;
        }

        return HandleUserSelection.moreCommands;
    }

//    @Override
//    protected void performExit() {
//        this.zoo.shutdownZoo();
//        super.performExit();
//    }
}
