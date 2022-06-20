package com.nology.zoology.user.command;

import com.nology.zoology.user.UserType;
import com.nology.zoology.zoo.Zoo;

public class UserCommandRunner extends CommandRunner {

    private UserType userType;
    private Zoo zoo;

    private static final String[] USER_COMMANDS = {
        "Play as visitor",
        "Play as Zoo Keeper",
        "Leave zoo"
    };

    public UserCommandRunner(Zoo zoo) {
        super(USER_COMMANDS, "User");
        this.zoo = zoo;
    }

    protected void runZooKeeperCommands() {
        AnimalCommandRunner commandRunner = new AnimalCommandRunner(zoo, UserType.zooKeeper);
        commandRunner.runCommands();
    }

    protected void runVisitorCommands() {
        AnimalCommandRunner commandRunner = new AnimalCommandRunner(zoo, UserType.visitor);
        commandRunner.runCommands();
    }

    @Override
    protected void beforeCommands() {
    }

    @Override
    protected boolean handleUserSelection(int userSelection) {
        if( userSelection == USER_COMMANDS.length ) {
            return false;
        }

        System.out.println("Performing user selection " + userSelection);
        switch (userSelection) {
            case 1:
                runZooKeeperCommands();
                break;
            case 2:
                runVisitorCommands();
                break;
        }

        return true;
    }

}
