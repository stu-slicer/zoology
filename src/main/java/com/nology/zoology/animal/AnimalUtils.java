package com.nology.zoology.animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalUtils {

    private static int nextId = 0;

    private static final List<String> names = new ArrayList<>();
    private static final Random RANDOM = new Random();

    static {
        names.add("Alice");
        names.add("Bob");
        names.add("Florence");
        names.add("Charlotte");
        names.add("Sydney");
        names.add("Ermintrude");
        names.add("Bonzo");
        names.add("Clyde");
        names.add("Tiddles");
        names.add("Leo");
        names.add("Fluffy");
        names.add("Butch");
    }

    public static int nextUniqueId() {
        return ++nextId;
    }

    public static String generateName() {
        return names.get( RANDOM.nextInt( names.size()) );
    }

    public static int generateAge() {
        return 1 + RANDOM.nextInt(15);
    }

}
