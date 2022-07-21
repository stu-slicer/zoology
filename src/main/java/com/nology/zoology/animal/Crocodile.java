package com.nology.zoology.animal;

public class Crocodile {

    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Snap!");
    }

    public String getInformation() {
        return this.name + " (" + this.id + "), a crocodile, is " + this.age + " years old";
    }

}
