package com.zenika.codingclub;

import sun.plugin.dom.exception.InvalidStateException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toList;

public class Hand {
    private final static int HIGH_CARD = 1;
    private final static int PAIR = 2;
    private final static int DOUBLE_PAIR = 3;
    private static final int FLUSH = 4;

    private final static Map<String, Integer> cardRanksFromStr;
    private final static List<RankDetector> rankDetectors;

    static {
        cardRanksFromStr = new HashMap<>();
        cardRanksFromStr.put("A", 14);
        for (int i = 2; i <= 10; i++) {
            cardRanksFromStr.put(String.valueOf(i), i);
        }
        cardRanksFromStr.put("J", 11);
        cardRanksFromStr.put("Q", 12);
        cardRanksFromStr.put("K", 13);
        rankDetectors = new ArrayList<>();
        rankDetectors.add(Hand::tryExtractColor);
        rankDetectors.add(Hand::tryExtractDoublePair);
        rankDetectors.add(Hand::tryExtractPair);
        rankDetectors.add(Hand::tryExtractHighestCard);
    }

    private final List<String> cards;
    private final List<Integer> cardRanks;

    public Hand(String card1, String card2, String card3, String card4, String card5) {
        this.cards = asList(card1, card2, card3, card4, card5);
        this.cardRanks = cards.stream()
                .map(Hand::extractCardRank)
                .sorted(reverseOrder())
                .collect(toList());
    }

    public boolean winsOver(Hand hand2) {
        return this.rank().compareTo(hand2.rank()) > 0;
    }

    private Rank rank() {
        for (RankDetector rankDetector : rankDetectors) {
            Rank rank = rankDetector.detect(cards, cardRanks);
            if (rank != null) {
                return rank;
            }
        }
        throw new InvalidStateException("Should detect at least highest card");
    }

    private static Rank tryExtractColor(List<String> cards, List<Integer> cardRanks) {
        Map<String, List<Integer>> cardsByColor = groupByColor(cards);
        if (cardsByColor.size() != 1) {
            return null;
        }
        return new Rank(FLUSH, cardRanks);
    }

    private static Rank tryExtractDoublePair(List<String> cards, List<Integer> cardRanks) {
        Map<Integer, Long> countByCardRank = countByCardRank(cards);
        boolean hasTwoPairs = countByCardRank.entrySet().stream()
                .filter(entry -> entry.getValue() == 2L)
                .map(Map.Entry::getKey)
                .sorted(reverseOrder())
                .count() == 2;
        if (!hasTwoPairs) {
            return null;
        }
        return new Rank(DOUBLE_PAIR, cardRanks);
    }

    private static Rank tryExtractPair(List<String> cards, List<Integer> cardRanks) {
        Map<Integer, Long> countByCardRank = countByCardRank(cards);
        boolean hasOnePair = countByCardRank.values().stream()
                .filter(value -> value == 2L)
                .count() == 1L;
        if (!hasOnePair) {
            return null;
        }
        return new Rank(PAIR, cardRanks);
    }

    private static Rank tryExtractHighestCard(List<String> cards, List<Integer> cardRanks) {
        return new Rank(HIGH_CARD, cardRanks);
    }

    private static Map<Integer, Long> countByCardRank(List<String> cards) {
        return cards.stream()
                .collect(Collectors.groupingBy(Hand::extractCardRank, counting()));
    }

    private static Map<String, List<Integer>> groupByColor(List<String> cards) {
        return cards.stream()
                .collect(Collectors.groupingBy(Hand::extractCardColor,
                        Collectors.mapping(Hand::extractCardRank, toList())));
    }

    private static Integer extractCardRank(String card) {
        String cardRankStr = card.substring(0, card.length() - 1);
        return cardRanksFromStr.get(cardRankStr);
    }

    private static String extractCardColor(String card) {
        return card.substring(card.length() - 1);
    }
}
