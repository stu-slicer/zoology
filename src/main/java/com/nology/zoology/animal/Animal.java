package com.nology.zoology.animal;

public abstract class Animal {

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
        this.hunger = hunger;
    }

    public boolean isHungry() {
        return this.hunger >= HUNGER_LEVEL;
    }

    public void feed() {
        hunger -= 10;
        makeSound();
    }

    public abstract void makeSound();

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
