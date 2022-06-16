package com.nology.zoology.animal;

public class Tiger extends Animal {

    public Tiger(int id, String name, int age) {
        super(id, name, age, false);
    }

    @Override
    public AnimalType getType() {
        return AnimalType.tiger;
    }

    @Override
    public void makeSound() {
        System.out.println("Grrrrrrr!");
    }

}
