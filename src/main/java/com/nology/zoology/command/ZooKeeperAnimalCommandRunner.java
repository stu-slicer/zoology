package com.nology.zoology.command;

import com.nology.zoology.user.UserType;
import com.nology.zoology.zoo.Zoo;

public class ZooKeeperAnimalCommandRunner extends AnimalCommandRunner {

    private static final String[] KEEPER_ANIMAL_COMMANDS = {
            "List all animals",
            "List animals by type",
            "List animals by stars",
            "List hungriest animals",
            "List most popular animals",
            "Visit an animal",
            "Exit"
    };

    public ZooKeeperAnimalCommandRunner(Zoo zoo, UserType userType) {
        super(KEEPER_ANIMAL_COMMANDS, zoo, userType);
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
                listAllAnimalsByStars();
                break;
            case 4:
                listHungriestAnimals();
                break;
            case 5:
                listMostPopularAnimals();
                break;
            case 6:
                runSingleAnimalCommands();
                break;
        }

        return true;
    }

}
