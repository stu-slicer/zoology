package com.nology.zoology.animal;

import java.util.Comparator;

public class SortByAnimalTypeThenName implements Comparator<Animal> {

    @Override
    public int compare(Animal left, Animal right) {
        if( left.getType().equals(right.getType()) ) {
            return left.getName().compareTo( right.getName() );
        }
        return left.getType().compareTo( right.getType() );
    }

}
