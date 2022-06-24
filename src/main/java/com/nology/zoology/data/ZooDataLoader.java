package com.nology.zoology.data;

import com.nology.zoology.animal.Animal;

import java.util.List;

/**
 * Handles saving and loading of data between games...
 * Currently just handles the loading of {@link Animal} data.
 */
public interface ZooDataLoader {

    void saveAnimalData(List<Animal> animals);
    List<Animal> loadAnimalData();

}
