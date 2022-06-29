package com.nology.zoology.animal;

import java.util.Comparator;

public class SortByAnimalName implements Comparator<Animal> {

    @Override
    public int compare(Animal left, Animal right) {
        if( left.getName().equals(right.getName()) ) {
            return left.getType().compareTo( right.getType() );
        }
        return left.getName().compareTo( right.getName() );
    }

}
