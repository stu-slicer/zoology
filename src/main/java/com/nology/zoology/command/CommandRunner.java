package com.nology.zoology.command;

import java.util.Scanner;

public abstract class CommandRunner {

    public static final String EXIT = "exit";
    public static final String QUIT = "quit";

    public enum HandleUserSelection {
        exit, doBreak, moreCommands;
    }

    private Scanner scanner = new Scanner(System.in);
    private String name;
    protected String[] commands;
    protected CommandType nextCommands;

    public CommandRunner(String[] commands, String name) {
        this.commands = commands;
        this.name = name;
    }

    public void runCommands() {

        intro();

        beforeCommands();

        boolean performExit = false;
        while (true) {

            printCommands();

            int userSelection = readIntegerInput(commands.length);

            // if exit ...

            HandleUserSelection moreCommands = handleUserSelection(userSelection);

            if( moreCommands != HandleUserSelection.moreCommands) {
                if( moreCommands == HandleUserSelection.doBreak ) {
                    break;
                } else {
                    performExit = true;
                    break;
                }
            }

        }

        if( performExit ) {
            performExit();
        }

    }

    protected void intro() {
        printMessage(String.format("\nCommands for %s\n", this.name));
    }

    protected void performExit() {
        System.exit(0);
    }

    /**
     * Perform any actions for the given user selection. If the commands needs to stop, for example exiting, then returns false
     * otherwise returns true.
     * @param userSelection
     * @return false is running commands needs to stop, otherwise returns true.
     */
    protected abstract HandleUserSelection handleUserSelection(int userSelection);

    /**
     * Read user's input as a number, should be a number between 1 and the limit. If the user wants to quit then return -1.
     * @param limit
     * @return
     */
    protected int readIntegerInput(int limit) {
        printMessage(String.format("Enter a number between 1 and %d:", limit));
        while( true ) {
            String line = scanner.nextLine();

            if( EXIT.equalsIgnoreCase(line.trim()) || QUIT.equalsIgnoreCase(line.trim()) ) {
                return -1;
            }

            try {
                int userSelection = Integer.valueOf(line.trim());

                if( userSelection < 1 || userSelection > limit ) {
                    printMessage("Please enter a number between 1 and " + limit);
                } else {
                    return userSelection;
                }
            } catch (Exception e) {
                printMessage("Please enter a number between 1 and " + limit);

            }
        }
    }

    /**
     * Reads the user's input as a String. Ignores any empty strings.
     * @param message
     * @return
     */
    protected String readStringInput(String message) {

        printMessage(message);

        while (true) {
            String userInput = scanner.nextLine();

            String userInputClean = userInput.trim().toLowerCase();

            if (!userInputClean.equals("")) {
                 return userInputClean;
            } else {
                printMessage("Unable to understand input, try again");
            }

        }
    }

    protected abstract void beforeCommands();

    protected void printIndexedCommands() {
        printIndexedCommands(commands);
    }

    protected void printIndexedCommands(String[] commands) {
        for (int i = 0; i < commands.length; i++) {
            printMessage((i + 1) + ": " + commands[i]);
        }
    }

    protected void printCommands() {
        printIndexedCommands();
    }

    protected void printMessage(String message) {
        System.out.println(message);
    }
}
