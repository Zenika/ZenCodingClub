
package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Game;

import java.util.Random;


public class GameRunner {

    public static void main(String[] args) {

        Random rand = new Random();

        run(rand);

    }

    public static void run(Random rand) {
        Game treviaGame = new Game();
        treviaGame.add("Chet");
        treviaGame.add("Pat");
        treviaGame.add("Sue");

        treviaGame.play(rand);
    }

}
