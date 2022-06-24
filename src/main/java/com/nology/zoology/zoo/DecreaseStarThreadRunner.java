package com.nology.zoology.zoo;

import com.nology.ColourUtils;
import com.nology.zoology.star.StarUtils;
import com.nology.zoology.star.Starrable;

import java.util.List;

/**
 * Decreases all animals with stars by one star.
 */
public class DecreaseStarThreadRunner implements Runnable {

    private List<? extends Starrable> animals;
    private int sleepMs = 600_000; // 10 minutes

    public DecreaseStarThreadRunner(List<? extends Starrable> animals) {
        this.animals = animals;
    }

    public DecreaseStarThreadRunner(List<? extends Starrable> animals, int sleepMs) {
        this.animals = animals;
        this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
        while ( true ) {
            try {
                Thread.sleep(sleepMs);
            } catch (InterruptedException e) {
                System.out.println("oops, interrupted");
                Thread.currentThread().interrupt();
            }

            if( Thread.currentThread().isInterrupted() ) {
                break;
            }

            System.out.println(ColourUtils.yellow("Some stars are going out " + StarUtils.BLACK_STAR + "..."));
            decreaseStars();

        }
    }

    public void decreaseStars() {
        for (Starrable starrable : animals) {
            starrable.removeStar();
        }
    }

}
