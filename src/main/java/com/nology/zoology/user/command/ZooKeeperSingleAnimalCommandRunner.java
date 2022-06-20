package com.nology.zoology.user.command;

import com.nology.zoology.animal.Animal;
import com.nology.zoology.zoo.Zoo;

/**
 * Command runner for a single {@link Animal}.
 */
public class ZooKeeperSingleAnimalCommandRunner extends SingleAnimalCommandRunner {

    private static final String[] SINGLE_ANIMAL_COMMANDS = {
            "Feed animal",
            "Visit another animal",
            "Exit"
    };

    public ZooKeeperSingleAnimalCommandRunner(Zoo zoo, Animal animal) {
        super(SINGLE_ANIMAL_COMMANDS, zoo, animal);
        this.zoo = zoo;
        this.animal = animal;
    }

    @Override
    protected boolean handleUserSelection(int userSelection) {
        if( userSelection == this.commands.length ) {
            return false;
        }

        System.out.println("Performing user selection " + userSelection);
        switch (userSelection) {
            case 1:
                feedAnimal();
                break;
            case 2:
                switchAnimal();
                break;
        }

        return true;
    }

}
