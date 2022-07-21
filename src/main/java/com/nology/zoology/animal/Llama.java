package com.nology.zoology.animal;

public class Llama extends Animal {

    public Llama(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Spit!");
    }

    @Override
    public String getInformation() {
        return this.name + " (" + this.id + "), a llama, is " + this.age + " years old";
    }

}
