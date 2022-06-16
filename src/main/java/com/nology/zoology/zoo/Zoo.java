package com.nology.zoology.zoo;

import com.nology.zoology.animal.*;

import java.util.ArrayList;
import java.util.Collections;

public class Zoo {

    private ArrayList<Animal> animals = new ArrayList<>();

    public void addAnimal(Tiger tiger) {
        this.animals.add(tiger);
    }

    public void addAnimal(Llama llama) {
        this.animals.add( llama );
    }

    public void addAnimal(Crocodile crocodile) {
        this.animals.add( crocodile );
    }

    public int getAnimalCount() {
        return this.animals.size();
    }

public void listAnimals(AnimalSorting animalSorting) {
    switch (animalSorting) {
        case byName:
            Collections.sort( animals, new SortByAnimalName() );
            break;
        case byType:
            Collections.sort( animals, new SortByAnimalTypeThenName() );
            break;
        default:
            Collections.sort( animals );
    }
    for (Animal animal : animals) {
        System.out.println("Animal: " + animal);
    }
}

}
