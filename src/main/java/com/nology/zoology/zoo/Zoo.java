package com.nology.zoology.zoo;

import com.nology.zoology.animal.*;
import com.nology.zoology.animal.loader.AnimalLoader;
import com.nology.zoology.data.ZooDataLoader;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class Zoo {

    private Log log = LogFactory.getLog(Zoo.class);

    public enum AnimalGeneration {
        fromLoader, fromPreviousGame;
    }

    private ArrayList<Animal> animals = new ArrayList<>();

    /**
     * Fast lookup for Animal by id
     */
    private Map<Integer, Animal> idMap = new HashMap<>();

    private Map<String, List<Animal>> nameMap = new HashMap<>();

    private AnimalGeneration animalGeneration = AnimalGeneration.fromPreviousGame;

    @Autowired
    private ZooDataLoader zooDataLoader;
    @Autowired
    private AnimalLoader animalLoader;

    @Autowired
    private IncreaseHungerThreadRunner increaseHungerThreadRunner;
    private Thread hungerThread;
    @Autowired
    private DecreaseStarThreadRunner decreaseStarThreadRunner;
    private Thread starsThread;

    @PostConstruct
    public void loadAndInitialise() {

        final List<Animal> toLoad = loadAnimals();

        for (Animal animalToLoad : toLoad) {
            this.animals.add( animalToLoad );
            addAnimalToMaps( animalToLoad );
        }

        log.info(String.format("Loaded %d animals", this.animals.size()));

        if( zooDataLoader != null ) {
            this.zooDataLoader.saveAnimalData(animals);
        }

        increaseHungerThreadRunner.setAnimals(this.animals);
        hungerThread = new Thread(increaseHungerThreadRunner);

        log.info(String.format("Hunger thread: hunger increases every %s seconds", increaseHungerThreadRunner.getSleepMs()/1000));

        decreaseStarThreadRunner.setAnimals( this.animals );
        log.info(String.format("Stars thread: stars are removed every %s seconds", decreaseStarThreadRunner.getSleepMs()/1000));
        starsThread = new Thread( decreaseStarThreadRunner);

        hungerThread.start();
        starsThread.start();
    }

    private List<Animal> loadAnimals() {
        List<Animal> toLoad = null;

        if( animalGeneration == AnimalGeneration.fromPreviousGame && this.zooDataLoader != null ) {
            toLoad = zooDataLoader.loadAnimalData();
            log.info("Animals loaded from previous game");

            if( ! toLoad.isEmpty() ) {
                return toLoad;
            }
            // if nothing loaded (no file) then get animals using AnimalLoader.
        }

        toLoad = animalLoader.loadAnimals();
        log.info("Animals loaded from loader");

        return toLoad;
    }

    public void shutdownZoo() {
        log.info("Shutting down threads, saving data and all that jazz");
        stopThreads();
        if (this.zooDataLoader != null) {
            this.zooDataLoader.saveAnimalData( this.animals );
        }
    }

    public void stopThreads() {
        log.info("Closing down!");
        hungerThread.interrupt();
        starsThread.interrupt();
        try {
            hungerThread.join();
            starsThread.join();
            System.out.println("... waiting for the thread(s) to stop...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
        addAnimalToMaps(animal);
    }

    public int getAnimalCount() {
        return this.animals.size();
    }

    private void addAnimalToMaps(Animal animal) {
        this.idMap.put( animal.getId(), animal);
        List<Animal> animalList = this.nameMap.getOrDefault( animal.getName().toLowerCase(), new ArrayList<>() );
        animalList.add(animal);
        this.nameMap.put( animal.getName().toLowerCase(), animalList);
    }

    public void listAnimals(AnimalSorting animalSorting) {
        // copy to prevent concurrency issues
        List<Animal> forSorting = new ArrayList<>(this.animals);
        switch (animalSorting) {
            case byName:
                Collections.sort(forSorting, new SortByAnimalName());
                break;
            case byType:
                Collections.sort(forSorting, new SortByAnimalTypeThenName());
                break;
            default:
                Collections.sort(forSorting);
        }
        for (Animal animal : forSorting) {
            System.out.println("Animal: " + animal);
        }
    }

    public List<Animal> getAnimals(AnimalSorting animalSorting) {
        // copy to prevent concurrency issues
        List<Animal> forSorting = new ArrayList<>(this.animals);
        switch (animalSorting) {
            case byName:
                Collections.sort(forSorting, new SortByAnimalName());
                break;
            case byType:
                Collections.sort(forSorting, new SortByAnimalTypeThenName());
                break;
            default:
                Collections.sort(forSorting);
        }
        return forSorting;
    }

    public List<Animal> getMostPopularAnimals(int top) {
        return this.animals.stream()
                .filter( a -> a.getStars() > 0 )
                .sorted( (a,b) -> b.getStars() - a.getStars() ) // reversed!
                .limit(top)
                .collect(Collectors.toList());
    }

    public List<Animal> getHungeriestAniamls(int threshold) {
        return this.animals.stream()
                .filter( a -> a.getHunger() > threshold )
                .sorted( (a,b) -> b.getHunger() - a.getHunger()  )
                .collect(Collectors.toList());
    }

    public Optional<Animal> findAnimalById(int id) {
        return Optional.ofNullable(this.idMap.get(id));
    }

    public List<Animal> findAnimalsByName(String name) {
        return this.nameMap.getOrDefault( name.toLowerCase(), new ArrayList<>() );
    }

}
