package com.nology.zoology.animal;

public enum AnimalType {

    crocodile((short) 50,(short) 1)
    ,lion
    ,tiger
    ,llama((short) 30, (short) 10)
    ,monkey;

    private final short feedHungerDecrease;
    private final short rateOfHunger;

    AnimalType() {
        feedHungerDecrease = 60;
        rateOfHunger = 5;
    }

    AnimalType(short feedHungerDecrease, short rateOfHunger) {
        this.feedHungerDecrease = feedHungerDecrease;
        this.rateOfHunger = rateOfHunger;
    }

    public short getFeedHungerDecrease() {
        return feedHungerDecrease;
    }

    public short getRateOfHunger() {
        return rateOfHunger;
    }

}
