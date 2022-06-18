package com.nology.zoology.animal;

import java.util.Comparator;

/**
 * Stars are sorted decreasing!!
 */
public class SortByStarsThenName implements Comparator<Animal> {

    @Override
    public int compare(Animal left, Animal right) {
        if( left.getStars() == right.getStars() ) {
            if( left.getName().equals( right.getName()) ) {
                return left.getType().compareTo( right.getType() );
            }
            return left.getName().compareTo( right.getName() );
        }
        return right.getStars() - left.getStars(); // reversed !!
    }

}
