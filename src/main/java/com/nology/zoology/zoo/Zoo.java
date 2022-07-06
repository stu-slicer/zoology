package com.nology.zoology.zoo;

import com.nology.zoology.animal.*;

import java.util.*;

public class Zoo {

    private ArrayList<Animal> animals = new ArrayList<>();

    /**
     * Fast lookup for Animal by id
     */
    private Map<Integer, Animal> idMap = new HashMap<>();

    private Map<String, List<Animal>> nameMap = new HashMap<>();

    Zoo() {
        // only construct with this package.
    }

    public void addAnimal(Tiger tiger) {
        this.animals.add(tiger);
        this.idMap.put( tiger.getId(), tiger);

        addAnimalToMaps(tiger);
    }


    public void addAnimal(Llama llama) {
        this.animals.add(llama);
        this.idMap.put( llama.getId(), llama);

        addAnimalToMaps(llama);
    }

    public void addAnimal(Crocodile crocodile) {
        this.animals.add(crocodile);
        this.idMap.put( crocodile.getId(), crocodile);

        addAnimalToMaps(crocodile);
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

    public Animal findAnimalById(int id) {
        return this.idMap.get(id);
    }

    public List<Animal> findAnimalsByName(String name) {
        return this.nameMap.get( name.toLowerCase() );
    }

}
