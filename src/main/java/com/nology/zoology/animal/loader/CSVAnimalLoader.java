package com.nology.zoology.animal.loader;

import com.nology.zoology.animal.*;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVAnimalLoader implements AnimalLoader {

    @Value("${csv-animal-loader}")
    private String filePath;

//    public CSVAnimalLoader(String filePath) {
//        this.filePath = filePath;
//    }

    @Override
    public List<Animal> loadAnimals() {

        List<Animal> animals = new ArrayList<>();

        List<String> lines = loadLinesFromFile();

        // 1,Lion,Charlie,12
        for (String line : lines) {

            String[] split = line.split(",");

            try {
                int id = Integer.valueOf( split[0] );
                AnimalType type = AnimalType.valueOf( split[1] );
                String name = split[2];
                int age = Integer.valueOf( split[3] );

                Animal toLoad = null;
                switch (type) {
                    case tiger:
                        toLoad = new Tiger( id, name, age);
                        break;
                    case llama:
                        toLoad = new Llama( id, name, age);
                        break;
                    case lion:
                        toLoad = new Lion( id, name, age);
                        break;
                    case crocodile:
                        toLoad = new Crocodile( id, name, age);
                        break;
                }

                animals.add( toLoad );
            } catch (IllegalArgumentException e) {
                System.err.println("Exception attempting to load line: " + line);
            }
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
}
