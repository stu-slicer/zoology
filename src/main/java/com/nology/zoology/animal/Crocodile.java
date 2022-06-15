package com.nology.zoology.animal;

public class Crocodile extends Animal {

    public Crocodile(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Snap, snap!");
    }
}
