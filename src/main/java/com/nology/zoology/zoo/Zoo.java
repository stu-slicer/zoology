package com.nology.zoology.zoo;

import com.nology.zoology.animal.Animal;
import com.nology.zoology.animal.Crocodile;
import com.nology.zoology.animal.Llama;
import com.nology.zoology.animal.Tiger;

import java.util.ArrayList;

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

}
