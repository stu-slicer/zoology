package com.nology.zoology.animal;

import java.util.*;

/**
 * Encapsulates the creation of animals.
 */
public class AnimalFactory {

    private List<Animal> creationHistory = new ArrayList<>();
    private Map<AnimalType, Set<String>> namesMap = new HashMap<>();

    public Animal createAnimal(AnimalType type) {
        Animal created;

        do {
            created = doCreateAnimal(type);
        } while ( namesMap.getOrDefault(created.getType(), new HashSet<>()).contains( created.getName() ) );

        creationHistory.add(created);

        Set<String> namesForType = namesMap.getOrDefault(created.getType(), new HashSet<>());
        namesForType.add( created.getName() );
        namesMap.put( created.getType(), namesForType );

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
