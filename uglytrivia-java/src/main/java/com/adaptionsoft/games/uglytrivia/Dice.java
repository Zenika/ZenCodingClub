package com.adaptionsoft.games.uglytrivia;

import java.util.Random;

public class Dice {


    private final Random rand;

    public Dice(Random rand) {
        this.rand = rand;
    }

    // TODO DiceResult
    public int roll() {
        return rand.nextInt(5) + 1;
    }
}
