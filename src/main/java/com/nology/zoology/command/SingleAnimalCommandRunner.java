package com.nology.zoology.command;

import com.nology.zoology.animal.Animal;
import com.nology.zoology.animal.AnimalSorting;
import com.nology.zoology.zoo.Zoo;

import java.util.List;
import java.util.Optional;

/**
 * Command runner for a single {@link Animal}.
 */
public abstract class SingleAnimalCommandRunner extends CommandRunner {

    protected Zoo zoo;
    protected Animal animal;

    public SingleAnimalCommandRunner(String[] commands,  Zoo zoo, Animal animal) {
        super(commands, "Animal");
        this.zoo = zoo;
        this.animal = animal;
    }

    protected void listAllAnimals() {
        printMessage("All animals in the zoo:");
        List<Animal> zooAnimals = this.zoo.getAnimals(AnimalSorting.byId);
        for (Animal zooAnimal : zooAnimals) {
            System.out.println(zooAnimal.getInformation());
        }
    }

    protected void feedAnimal() {
        animal.feed();
    }

    protected void listAllAnimalsByType() {
        printMessage("All animals in the zoo:");
        List<Animal> zooAnimals = this.zoo.getAnimals(AnimalSorting.byType);
        for (Animal zooAnimal : zooAnimals) {
            System.out.println(zooAnimal.getInformation());
        }
    }

    protected void petAnimal() {
        if( animal.isPettable() ) {
            animal.pet();
        } else {
            printMessage("I don't think so!");
        }
    }

    protected void giveStar() {
        this.animal.receiveStar(1);
        this.animal.makeSound();
    }

    protected void selectAnimalIfMissing() {
        if (this.animal == null) {
            this.animal = selectAnimal();
        }
    }

    protected void switchAnimal() {
        this.animal = selectAnimal();
    }

    private Animal selectAnimal() {
        Animal selected = null;
        while(true) {
            listAllAnimals();
            String idOrName = readStringInput("Enter the id or name for the animal:");
            Animal found = null;
            try {
                int id = Integer.valueOf( idOrName );
                Optional<Animal> animalById = zoo.findAnimalById(id);
                if( animalById.isPresent() ) {
                    selected = animalById.get();
                    break;
                }
            } catch (NumberFormatException e) {
                List<Animal> animalsByName = zoo.findAnimalsByName(idOrName);
                if (animalsByName.size() == 1) {
                    selected = animalsByName.get(0);
                    break;
                }
                printMessage("Oh no, there's more than one animal with the name " + idOrName + ", please use the id.");
            }
        }
        if (selected != null) {
            printMessage(String.format("You have selected %s (%d) the %s", selected.getName(), selected.getId(), selected.getType()));
        }
        return selected;
    }

    @Override
    protected void beforeCommands() {
        selectAnimalIfMissing();
    }

    @Override
    protected HandleUserSelection handleUserSelection(int userSelection) {
        if( userSelection == this.commands.length ) {
            return HandleUserSelection.doBreak;
        }

        System.out.println("Performing user selection " + userSelection);
        switch (userSelection) {
            case 1:
                feedAnimal();
                break;
            case 2:
                petAnimal();
                break;
            case 3:
                giveStar();
                break;
            case 4:
                switchAnimal();
                break;
        }

        return HandleUserSelection.moreCommands;
    }

}
