package com.nology.zoology.animal;

public class Animal {

    protected int id;
    protected String name;
    protected int age;

    public Animal(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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
        System.out.println("They same nothing..."); // silence
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("");
        sb.append(getClass().getSimpleName());
        sb.append("[id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(']');
        return sb.toString();
    }

}
