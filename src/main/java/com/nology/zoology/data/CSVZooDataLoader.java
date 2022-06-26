package com.nology.zoology.data;

import com.nology.zoology.animal.*;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CSVZooDataLoader implements ZooDataLoader {

    public static final String DEFAULT_DATA_FILE = "src/main/resources/zoology-data-file.csv";

    private static int ANIMAL_ID = 0;
    private static int ANIMAL_TYPE = 1;
    private static int ANIMAL_NAME = 2;
    private static int ANIMAL_AGE = 3;
    private static int ANIMAL_POPULARITY = 4;
    private static int ANIMAL_STARS = 5;
    private static int ANIMAL_HUNGER = 6;
    private static int ANIMAL_PETTABLE = 7;

    private String filePath = DEFAULT_DATA_FILE;

    public CSVZooDataLoader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void saveAnimalData(List<Animal> animals) {
        List<String> lines = new ArrayList<>();

        // 1,Lion,Leo,12,popularity,stars,hunger,pettable
        for (Animal animal : animals) {
            StringBuilder sb = new StringBuilder();
            sb.append(animal.getId());
            sb.append(",");
            sb.append(animal.getType());
            sb.append(",");
            sb.append(animal.getName());
            sb.append(",");
            sb.append(animal.getAge());
            sb.append(",");
            sb.append(animal.getPopularity());
            sb.append(",");
            sb.append(animal.getStars());
            sb.append(",");
            sb.append(animal.getHunger());
            sb.append(",");
            sb.append(animal.isPettable());
            lines.add( sb.toString() );
        }

        saveLinesToFile(lines);
    }

    @Override
    public List<Animal> loadAnimalData() {
        List<Animal> animals = new ArrayList<>();

        List<String> lines = loadLinesFromFile();

        // 1,Lion,Leo,12,popularity,stars,hunger,pettable
        for (String line : lines) {

            String[] split = line.split(",");

            int id = Integer.valueOf( split[ANIMAL_ID] );
            AnimalType type = AnimalType.valueOf( split[ANIMAL_TYPE] );
            String name = split[ANIMAL_NAME];
            int age = Integer.valueOf( split[ANIMAL_AGE] );
            int popularity = Integer.valueOf( split[ANIMAL_POPULARITY] );
            int stars = Integer.valueOf( split[ANIMAL_STARS] );
            short hunger = Short.valueOf( split[ANIMAL_HUNGER] );
            boolean pettable = Boolean.valueOf( split[ANIMAL_PETTABLE] );

            Animal toLoad = AnimalBuilder.animal(name)
                    .withId(id)
                    .withType(type)
                    .withAge(age)
                    .withPettable(pettable)
                    .withPopularity(popularity)
                    .withStars(stars)
                    .withHunger(hunger)
                    .build();
            animals.add( toLoad );
        }

        return animals;
    }

    private List<String> loadLinesFromFile() {
        try {
            List<String> lines = Files.readAllLines(Path.of(this.filePath));
            return lines;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void saveLinesToFile(List<String> lines) {
        try {
            Files.write(Path.of(this.filePath), lines, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
