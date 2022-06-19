package com.nology.zoology.zoo;

import com.nology.zoology.animal.Animal;

import java.util.List;

public class IncreaseHungerThread implements Runnable {

    private List<Animal> animals;

    public IncreaseHungerThread(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public void run() {
        while ( true ) {
            try {
                Thread.sleep(60_000);
            } catch (InterruptedException e) {
                System.out.println("oops, interrupted");
                Thread.currentThread().interrupt();
            }

            if( Thread.currentThread().isInterrupted() ) {
                System.out.println("oops, interrupted " + Thread.currentThread().isInterrupted());
                System.out.println("oops, interrupted " + Thread.currentThread().isInterrupted());
                break;
            }

            System.out.println("Those animals are getting hungry...");
            increaseHunger();

        }
    }

    public void increaseHunger() {
        for (Animal animal : animals) {
            animal.increaseHunger();
        }
    }

}
