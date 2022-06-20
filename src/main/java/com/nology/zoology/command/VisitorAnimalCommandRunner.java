package com.nology.zoology.command;

import com.nology.zoology.user.UserType;
import com.nology.zoology.zoo.Zoo;

public class VisitorAnimalCommandRunner extends AnimalCommandRunner {

    private static final String[] ANIMAL_COMMANDS = {
            "List all animals",
            "List animals by type",
            "Visit an animal",
            "Exit"
    };

    public VisitorAnimalCommandRunner(Zoo zoo, UserType userType) {
        super(ANIMAL_COMMANDS, zoo, userType);
    }

    @Override
    protected boolean handleUserSelection(int userSelection) {
        if( userSelection == this.commands.length ) {
            return false;
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
                runSingleAnimalCommands();
                break;
        }

        return true;
    }

}
