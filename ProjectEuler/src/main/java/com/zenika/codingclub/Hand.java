package com.zenika.codingclub;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Hand {

    private String cards;

    public Hand(String cards) {
        this.cards = cards;
    }

    public boolean winsOver(Hand hand2) {
        final String[] cardsArray = cards.split(" ");
        final String[] otherCardsArray = hand2.cards.split(" ");
        return hasPair(cardsArray) && !hasPair(otherCardsArray);
    }

    private boolean hasPair(String[] cardsArray) {
        final Map<String, Long> countByValue = Arrays.stream(cardsArray)
                .collect(Collectors.groupingBy(this::extractCardValue, Collectors.counting()));
        return countByValue.values().contains(2L);
    }

    private String extractCardValue(String card) {
        return card.substring(0, card.length() - 1);
    }
}
