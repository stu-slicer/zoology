package com.nology.zoology.animal;

import com.nology.ColourUtils;
import com.nology.zoology.star.StarUtils;
import com.nology.zoology.star.Starrable;

import java.util.Comparator;

public abstract class Animal implements Comparable<Animal>, Starrable {

    private static final int HUNGER_LEVEL = 40;

    protected int id;
    protected String name;
    protected int age;
    protected boolean pettable;
    protected int popularity;
    protected int stars;
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

    @Override
    public void receiveStar(int stars) {
        if( stars < 1 || stars > 10 ) {
            throw new IllegalArgumentException("Number of stars must be betweem 1 amd 10");
        }
        this.stars = Math.min( this.stars + stars, 10  ); // no more than 10 stars!
        this.popularity = (popularity + (stars * 10)) % 100;
    }

    @Override
    public int getStars() {
        return this.stars;
    }

    public abstract void makeSound();

    public String getInformation() {
        return ColourUtils.red(this.name) + String.format(" (#%d), a %s, is %d years old, popularity %d%%, stars %s, hunger %d%%",
                this.id, getType(), this.age, this.popularity, StarUtils.printStars(this, 10), this.hunger);
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
