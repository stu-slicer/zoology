package com.nology.zoology.animal;

public class AnimalBuilder {

    private Integer id;
    private AnimalType type;
    private String name;
    private Integer age;
    private boolean pettable = false;
    private Integer popularity;
    private Integer stars;
    private Short hunger;

    public AnimalBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public AnimalBuilder withType(AnimalType type) {
        this.type = type;
        return this;
    }

    public AnimalBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public AnimalBuilder withPettable(boolean pettable) {
        this.pettable = pettable;
        return this;
    }

    public AnimalBuilder withPopularity(int popularity) {
        this.popularity = popularity;
        return this;
    }

    public AnimalBuilder withStars(int stars) {
        this.stars = stars;
        return this;
    }

    public AnimalBuilder withHunger(short hunger) {
        this.hunger = hunger;
        return this;
    }

    public Animal build() {
        if( this.id == null ) {
            throw new IllegalStateException("Please give an ID!");
        }
        if( this.type == null ) {
            throw new IllegalStateException("Please give an Animal Type!");
        }
        if( this.name == null || "".equals(this.name)) {
            throw new IllegalStateException("Please give an Name!");
        }
        if( this.age == null ) {
            throw new IllegalStateException("Please give an Age!");
        }
        if( this.popularity == null ) {
            throw new IllegalStateException("Please give a Popularity percentage!");
        }
        if( this.stars == null ) {
            throw new IllegalStateException("Please give a Stars count!");
        }
        if( this.hunger == null ) {
            throw new IllegalStateException("Please give a Hunger percentage!");
        }
        Animal built = null;
        switch (type) {
            case tiger:
                built = new Tiger(this.id, this.name, this.age);
                break;

            case llama:
                built = new Llama(this.id, this.name, this.age);
                break;

            case crocodile:
                built = new Crocodile(this.id, this.name, this.age);
                break;
            default:
                throw new IllegalStateException("Sorry don't know how to make " + type);
        }
        built.setPettable(pettable);
        built.setPopularity(popularity);
        built.setStars(stars);
        built.setHunger(hunger);
        return built;
    }

    public static AnimalBuilder animal(String name) {
        AnimalBuilder builder = new AnimalBuilder();
        return builder;
    }

}
