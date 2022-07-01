package com.nology.zoology.zoo;

import com.nology.ColourUtils;
import com.nology.zoology.animal.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IncreaseHungerThreadRunner implements Runnable {

    private List<Animal> animals;
    @Value("${thread-runner.incresae-hunger-ms}")
    private int sleepMs = 60_000; // 1 minute


    @Override
    public void run() {
        while ( true ) {
            try {
                Thread.sleep(this.sleepMs);
            } catch (InterruptedException e) {
                System.out.println("oops, interrupted");
                Thread.currentThread().interrupt();
            }

            if( Thread.currentThread().isInterrupted() ) {
                System.out.println("oops, interrupted " + Thread.currentThread().isInterrupted());
                System.out.println("oops, interrupted " + Thread.currentThread().isInterrupted());
                break;
            }

            System.out.println(ColourUtils.blue("Those animals are getting hungry..."));
            increaseHunger();

        }
    }

    public void increaseHunger() {
        for (Animal animal : animals) {
            animal.increaseHunger();
        }
    }

    public int getSleepMs() {
        return sleepMs;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
