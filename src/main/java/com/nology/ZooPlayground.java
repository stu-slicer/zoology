package com.nology;

import com.nology.zoology.command.UserCommandRunner;
import com.nology.zoology.zoo.Zoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/**
 * Implements {@link CommandLineRunner} so run methods is run immediately after Spring has built and configured the application.
 * This is the way into the Zoo!
 * @deprecated no longer needed as this is now a backend server!
 */
//@Component
    @Deprecated
public class ZooPlayground implements CommandLineRunner {

    @Autowired
    private Zoo zoo;

    @Override
    public void run(String... args) throws Exception {

        UserCommandRunner userCommandRunner = new UserCommandRunner(zoo);

        userCommandRunner.runCommands();

    }

}
