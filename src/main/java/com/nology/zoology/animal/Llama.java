package com.nology.zoology.animal;

public class Llama extends Animal {

    public Llama(int id, String name, int age) {
        super(id, name, age, true);
    }

    @Override
    public AnimalType getType() {
        return AnimalType.llama;
    }

    @Override
    public void makeSound() {
        System.out.println("Spit!");
    }

}
