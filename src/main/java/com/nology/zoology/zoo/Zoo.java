package com.nology.zoology.zoo;

import com.nology.zoology.animal.*;
import com.nology.zoology.animal.loader.AnimalLoader;

import java.util.*;

public class Zoo {

    private ArrayList<Animal> animals = new ArrayList<>();

    /**
     * Fast lookup for Animal by id
     */
    private Map<Integer, Animal> idMap = new HashMap<>();

    private Map<String, List<Animal>> nameMap = new HashMap<>();

    private AnimalLoader animalLoader;

    public Zoo(AnimalLoader animalLoader) {
        this.animalLoader = animalLoader;
        List<Animal> toLoad = animalLoader.loadAnimals();
        for (Animal animalToLoad : toLoad) {
            this.animals.add( animalToLoad );
            addAnimalToMaps(animalToLoad );
        }
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
        addAnimalToMaps(animal);
    }

    public int getAnimalCount() {
        return this.animals.size();
    }

    private void addAnimalToMaps(Animal animal) {
        this.idMap.put( animal.getId(), animal);
        List<Animal> animalList = this.nameMap.getOrDefault( animal.getName().toLowerCase(), new ArrayList<>() );
        animalList.add(animal);
        this.nameMap.put( animal.getName().toLowerCase(), animalList);
    }

    public void listAnimals(AnimalSorting animalSorting) {
        switch (animalSorting) {
            case byName:
                Collections.sort(animals, new SortByAnimalName());
                break;
            case byType:
                Collections.sort(animals, new SortByAnimalTypeThenName());
                break;
            default:
                Collections.sort(animals);
        }
        for (Animal animal : animals) {
            System.out.println("Animal: " + animal);
        }
    }

    public List<Animal> getAnimals(AnimalSorting animalSorting) {
        switch (animalSorting) {
            case byName:
                Collections.sort(animals, new SortByAnimalName());
                break;
            case byType:
                Collections.sort(animals, new SortByAnimalTypeThenName());
                break;
            default:
                Collections.sort(animals);
        }
        return List.copyOf( animals );
    }

    public Optional<Animal> findAnimalById(int id) {
        return Optional.ofNullable(this.idMap.get(id));
    }

    public List<Animal> findAnimalsByName(String name) {
        return this.nameMap.getOrDefault( name.toLowerCase(), new ArrayList<>() );
    }

}
