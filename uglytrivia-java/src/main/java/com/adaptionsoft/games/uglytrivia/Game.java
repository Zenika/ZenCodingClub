package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Game {
    private final int NUMBER_OF_COINS_TO_WIN = 6;
    private List<String> playerNames;
    private int[] places = new int[6];
    private int[] purses = new int[6];
    private boolean[] inPenaltyBox = new boolean[6];

    private LinkedList<Question> popQuestions = new LinkedList<>();
    private LinkedList<Question> scienceQuestions = new LinkedList<>();
    private LinkedList<Question> sportsQuestions = new LinkedList<>();
    private LinkedList<Question> rockQuestions = new LinkedList<>();

    private final Dice dice;

    private Game(Random rand, List<Player> players) {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast(new Question("Pop Question " + i, rand));
            scienceQuestions.addLast(new Question("Science Question " + i, rand));
            sportsQuestions.addLast(new Question("Sports Question " + i, rand));
            rockQuestions.addLast(new Question("Rock Question " + i, rand));
        }
        this.dice = new Dice(rand);

        playerNames = players.stream()
                .map(Player::name)
                .collect(Collectors.toList());
    }

    public void play() {
        int currentPlayer = 0;

        while(true) {
            System.out.println(playerNames.get(currentPlayer) + " is the current player");
            int roll = dice.roll();
            System.out.println("They have rolled a " + roll);

            if (isInPenaltyBox(currentPlayer)) {
                if (allowsToLeavePenaltyBox(roll)) {
                    leavePenaltyBox(currentPlayer);
                    System.out.println(playerNames.get(currentPlayer) + " is getting out of the penalty box");
                } else {
                    System.out.println(playerNames.get(currentPlayer) + " is not getting out of the penalty box");
                    continue;
                }
            }
            movePlayer(currentPlayer, roll);
            System.out.println(playerNames.get(currentPlayer)
                    + "'s new location is "
                    + places[currentPlayer]);

            String currentCategory = currentCategory(currentPlayer);
            System.out.println("The category is " + currentCategory);
            Question question = drawQuestion(currentCategory);
            System.out.println(question.label());

            if (question.isCorrectAnswer()) {
                System.out.println("Answer was correct!!!!");
                purses[currentPlayer]++;
                System.out.println(playerNames.get(currentPlayer)
                        + " now has "
                        + purses[currentPlayer]
                        + " Gold Coins.");

                // todo rename this function @Romain
                if(didPlayerWin(currentPlayer)) {
                    return;
                }
            } else {
                System.out.println("Question was incorrectly answered");
                System.out.println(playerNames.get(currentPlayer) + " was sent to the penalty box");
                inPenaltyBox[currentPlayer] = true;
            }

            currentPlayer = (currentPlayer + 1) % playerNames.size();
        }
    }

    private boolean allowsToLeavePenaltyBox(int roll) {
        return roll % 2 != 0;
    }

    private boolean isInPenaltyBox(int playerIndex) {
        return inPenaltyBox[playerIndex];
    }

    private void leavePenaltyBox(int playerIndex) {
        // fixme bug in golden master
//        inPenaltyBox[playerIndex] = false;
    }

    private void movePlayer(int playerIndex, int roll) {
        places[playerIndex] = (places[playerIndex] + roll) % 12;
    }

    private Question drawQuestion(String currentCategory) {
        if (currentCategory.equals("Pop")) {
            return popQuestions.removeFirst();
        }
        if (currentCategory.equals("Science")) {
            return scienceQuestions.removeFirst();
        }
        if (currentCategory.equals("Sports")) {
            return sportsQuestions.removeFirst();
        }
        if (currentCategory.equals("Rock")) {
            return rockQuestions.removeFirst();
        }

        throw new IllegalStateException("Unknown category " + currentCategory);
    }


    private String currentCategory(int playerIndex) {
        if (places[playerIndex] == 0) return "Pop";
        if (places[playerIndex] == 4) return "Pop";
        if (places[playerIndex] == 8) return "Pop";
        if (places[playerIndex] == 1) return "Science";
        if (places[playerIndex] == 5) return "Science";
        if (places[playerIndex] == 9) return "Science";
        if (places[playerIndex] == 2) return "Sports";
        if (places[playerIndex] == 6) return "Sports";
        if (places[playerIndex] == 10) return "Sports";
        return "Rock";
    }

    private boolean didPlayerWin(int playerIndex) {
        if (isInPenaltyBox(playerIndex)) {
            return false;
        }
        return purses[playerIndex] == NUMBER_OF_COINS_TO_WIN;
    }

    public static Builder withPlayerName(String name) {
        return new Builder().andName(name);
    }

    public static class Builder {
        private final List<Player> players = new ArrayList<>();

        public Builder andName(String name) {
            players.add(new Player(name));

            System.out.println(name + " was added");
            System.out.println("They are player number " + players.size());
            return this;
        }

        public Game andRandom(Random random) {
            return new Game(random, players);
        }
    }


}
