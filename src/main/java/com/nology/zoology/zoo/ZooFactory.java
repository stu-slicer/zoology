package com.nology.zoology.zoo;

import com.nology.zoology.animal.loader.AnimalLoader;

public final class ZooFactory {

    private static Zoo zoo;

    private ZooFactory() {
    }

    public static Zoo getOrCreateZoo(AnimalLoader animalLoader) {
        if( ZooFactory.zoo == null ) {
            ZooFactory.zoo = new Zoo(animalLoader);
        }
        return zoo;
    }

}