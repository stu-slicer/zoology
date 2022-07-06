package com.nology.zoology.zoo;

public final class ZooFactory {

    private static Zoo zoo;

    private ZooFactory() {
    }

    public static Zoo getOrCreateZoo() {
        if( ZooFactory.zoo == null ) {
            ZooFactory.zoo = new Zoo();
        }
        return zoo;
    }

}