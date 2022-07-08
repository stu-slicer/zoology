package com.nology.zoology.zoo;

import com.nology.zoology.animal.loader.AnimalLoader;
import com.nology.zoology.data.ZooDataLoader;

/**
 * A builder for creating a new {@link Zoo} object.
 */
public class ZooBuilder {

    private AnimalLoader animalLoader;
    private ZooDataLoader zooDataLoader;

    public ZooBuilder withAnimalLoader(AnimalLoader animalLoader) {
        this.animalLoader = animalLoader;
        return this;
    }

    public ZooBuilder withZooDataLoader(ZooDataLoader zooDataLoader) {
        this.zooDataLoader = zooDataLoader;
        return this;
    }

    public Zoo build() {

        if( animalLoader == null ) {
            throw new IllegalStateException("You must provide a AnimalLoader!");
        }
        Zoo zoo = new Zoo(animalLoader, zooDataLoader);

        return zoo;
    }

    public static ZooBuilder create() {
        ZooBuilder builder = new ZooBuilder();
        return builder;
    }

}
