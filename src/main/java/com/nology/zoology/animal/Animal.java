package com.nology.zoology.animal;

import com.nology.ColourUtils;

import java.util.Comparator;

public abstract class Animal implements Comparable<Animal> {

    private static final int HUNGER_LEVEL = 40;

    protected int id;
    protected String name;
    protected int age;
    protected boolean pettable;
    protected int popularity;
    protected short hunger = 50;

    public Animal(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Animal(int id, String name, int age, boolean pettable) {
        this(id, name, age);
        this.pettable = pettable;
    }

    public abstract AnimalType getType();

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
        if( name == null || "".equals(name.trim()) ) {
            throw new IllegalArgumentException("Name must be a valid name");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if( age < 1 || age > 99 ) {
            throw new IllegalArgumentException("Age must be betweem 1 and 99 years");
        }
        this.age = age;
    }

    public boolean isPettable() {
        return pettable;
    }

    public void setPettable(boolean pettable) {
        this.pettable = pettable;
    }

    public int getPopularity() {
        return popularity;
    }

    public short getHunger() {
        return hunger;
    }

    /**
     * For Testing
     * @param hunger
     */
    void setHunger(short hunger) {
        if( hunger < 0 || hunger > 100 ) {
            throw new IllegalArgumentException("Hunger must be betweem 0 and 100");
        }
        this.hunger = hunger;
    }

    public boolean isHungry() {
        return this.hunger >= HUNGER_LEVEL;
    }

    public void feed() {
        hunger -= 10;
        makeSound();
    }

    public void pet() {
        if( isPettable() ) {
            System.out.println(this.name + " likes that!");
            this.popularity += 5;
        } else {
            makeSound();
        }
    }

    public abstract void makeSound();

    public String getInformation() {
        return ColourUtils.red(this.name) + String.format(" (#%d), a %s, is %d years old, popularity %d%%, hunger %d%%",
                this.id, getType(), this.age, this.popularity, this.hunger);
    }

    @Override
    public int compareTo(Animal other) {
        // order by id
        return this.id - other.id;
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
