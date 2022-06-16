package com.nology.zoology.animal;

public class Lion extends Animal {

    public Lion(int id, String name, int age) {
        super(id, name, age, true);
    }

    @Override
    public AnimalType getType() {
        return AnimalType.lion;
    }

    @Override
    public void makeSound() {
        System.out.println("Roooaaaarrrrr!");
    }
}
