package com.nology.zoology.animal;

public class Tiger extends Animal {

    public Tiger(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Grrrrrrr!");
    }

    @Override
    public String getInformation() {
        return this.name + " (" + this.id + "), a tiger, is " + this.age + " years old";
    }
}
