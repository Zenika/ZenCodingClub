package com.adaptionsoft.games.uglytrivia;

import java.util.Random;

public class Question {

    private final String label;
    private final Random random;

    public Question(String label, Random random) {
        this.label = label;
        this.random = random;
    }

    public String label() {
        return label;
    }

    public boolean isCorrectAnswer() {
        return random.nextInt(9) != 7;
    }

    public enum Category {
        POP,
        SCIENCE,
        SPORTS,
        ROCK,
    }
}
