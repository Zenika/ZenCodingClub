
package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameRunner {

    public static void main(String[] args) {

        Random rand = new Random();

        run(rand);

    }

    public static void run(Random rand) {
        Game triviaGame = Game.withPlayerName("Chet")
                .andName("Pat")
                .andName("Sue")
                .andRandom(rand);
        triviaGame.play();
    }

}
