package com.nology.zoology.animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates the creation of animals.
 */
public class AnimalFactory {

    private List<Animal> creationHistory = new ArrayList<>();

    public Animal createAnimal(AnimalType type) {
        Animal created = doCreateAnimal(type);
        creationHistory.add(created);
        return created;
    }

    private Animal doCreateAnimal(AnimalType type) {
        switch (type) {
            case tiger:
                return new Tiger( AnimalUtils.nextUniqueId(), AnimalUtils.generateName(), AnimalUtils.generateAge() );
            case llama:
                return new Llama( AnimalUtils.nextUniqueId(), AnimalUtils.generateName(), AnimalUtils.generateAge() );
            case lion:
                return new Lion( AnimalUtils.nextUniqueId(), AnimalUtils.generateName(), AnimalUtils.generateAge() );
            case crocodile:
                return new Crocodile( AnimalUtils.nextUniqueId(), AnimalUtils.generateName(), AnimalUtils.generateAge() );
        }
        throw new IllegalArgumentException(String.format("Animal type %s can't be created", type));
    }

}
