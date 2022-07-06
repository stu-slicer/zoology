package com.nology.zoology.zoo;

import com.nology.zoology.animal.loader.AnimalLoader;

public class ZooBuilder {

    private AnimalLoader animalLoader;

    public ZooBuilder withAnimalLoader(AnimalLoader animalLoader) {
        this.animalLoader = animalLoader;
        return this;
    }

    public Zoo build() {

        if( animalLoader == null ) {
            throw new IllegalStateException("You must provide a AnimalLoader!");
        }
        Zoo zoo = new Zoo(animalLoader);

        return zoo;
    }

    public static ZooBuilder create() {
        ZooBuilder builder = new ZooBuilder();
        return builder;
    }

}
