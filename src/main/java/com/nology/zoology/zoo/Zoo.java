package com.nology.zoology.zoo;

import com.nology.zoology.animal.*;
import com.nology.zoology.animal.loader.AnimalLoader;
import com.nology.zoology.data.ZooDataLoader;

import java.util.*;
import java.util.stream.Collectors;

public class Zoo {

    public enum AnimalGeneration {
        fromLoader, fromPreviousGame;
    }

    private ArrayList<Animal> animals = new ArrayList<>();

    /**
     * Fast lookup for Animal by id
     */
    private Map<Integer, Animal> idMap = new HashMap<>();

    private Map<String, List<Animal>> nameMap = new HashMap<>();

    private ZooDataLoader zooDataLoader;
    private AnimalLoader animalLoader;

    private AnimalGeneration animalGeneration = AnimalGeneration.fromPreviousGame;

    public Zoo(AnimalLoader animalLoader) {
        this.animalLoader = animalLoader;
    }

    public Zoo(AnimalLoader animalLoader, ZooDataLoader zooDataLoader) {
        this(animalLoader);
        this.zooDataLoader = zooDataLoader;

        final List<Animal> toLoad = loadAnimals();

        for (Animal animalToLoad : toLoad) {
            this.animals.add( animalToLoad );
            addAnimalToMaps( animalToLoad );
        }

        if( zooDataLoader != null ) {
            this.zooDataLoader.saveAnimalData(animals);
        }

    }

    public void shutdownZoo() {
        if (this.zooDataLoader != null) {
            this.zooDataLoader.saveAnimalData( this.animals );
        }
    }

    private List<Animal> loadAnimals() {
        List<Animal> toLoad = null;

        if( animalGeneration == AnimalGeneration.fromPreviousGame && this.zooDataLoader != null ) {
            toLoad = zooDataLoader.loadAnimalData();
            System.out.println("Animals loaded from previous game");

            if( ! toLoad.isEmpty() ) {
                return toLoad;
            }
            // if nothing loaded (no file) then get animals using AnimalLoader.
        }

        toLoad = animalLoader.loadAnimals();
        System.out.println("Animals loaded from loader");

        return toLoad;
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

    public List<Animal> getMostPopularAnimals(int top) {
        return this.animals.stream()
                .filter( a -> a.getStars() > 0 )
                .sorted( (a,b) -> b.getStars() - a.getStars() ) // reversed!
                .limit(top)
                .collect(Collectors.toList());
    }

    public List<Animal> getHungeriestAniamls() {
        return this.animals.stream()
                .filter( a -> a.getHunger() > 30 )
                .sorted( (a,b) -> b.getHunger() - a.getHunger()  )
                .collect(Collectors.toList());
    }

    public Optional<Animal> findAnimalById(int id) {
        return Optional.ofNullable(this.idMap.get(id));
    }

    public List<Animal> findAnimalsByName(String name) {
        return this.nameMap.getOrDefault( name.toLowerCase(), new ArrayList<>() );
    }

    public void setZooDataLoader(ZooDataLoader zooDataLoader) {
        this.zooDataLoader = zooDataLoader;
    }
}
