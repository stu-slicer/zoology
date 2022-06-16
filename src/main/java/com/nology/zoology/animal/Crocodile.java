package com.nology.zoology.animal;

import static com.nology.zoology.animal.AnimalType.crocodile;

public class Crocodile extends Animal {

    public Crocodile(int id, String name, int age) {
        super(id, name, age, false);
    }

    @Override
    public AnimalType getType() {
        return crocodile;
    }

    @Override
    public void makeSound() {
        System.out.println("Snap, snap!");
    }
}
