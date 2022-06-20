package com.nology.zoology.command;

import com.nology.zoology.animal.Animal;
import com.nology.zoology.zoo.Zoo;

/**
 * Command runner for a single {@link Animal}.
 */
public class VisitorSingleAnimalCommandRunner extends SingleAnimalCommandRunner {

    private static final String[] SINGLE_ANIMAL_COMMANDS = {
            "Pet animal",
            "Give star",
            "Visit another animal",
            "Exit"
    };

    public VisitorSingleAnimalCommandRunner(Zoo zoo, Animal animal) {
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
                petAnimal();
                break;
            case 2:
                giveStar();
                break;
            case 3:
                switchAnimal();
                break;
        }

        return true;
    }

}
