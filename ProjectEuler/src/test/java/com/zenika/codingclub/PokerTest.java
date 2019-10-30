package com.zenika.codingclub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PokerTest {

    @Test
    void PairShouldWinAgainstHighCard() {
        Hand hand1 = new Hand("AC", "AH", "2C", "3C", "6D");
        Hand hand2 = new Hand("QD", "KC", "9D", "8S", "7S");
        Assertions.assertTrue(hand1.winsOver(hand2));
    }

    @Test
    void HighCardShouldLoseAgainstPair() {
        Hand hand1 = new Hand("AC", "AH", "2C", "3C", "6D");
        Hand hand2 = new Hand("QD", "KC", "9D", "8S", "7S");
        Assertions.assertFalse(hand2.winsOver(hand1));
    }

    @Test
    void DoublePairShouldWinAgainstPair() {
        Hand hand1 = new Hand("AC", "AH", "2C", "2D", "6D");
        Hand hand2 = new Hand("QD", "QC", "9D", "8S", "7S");
        Assertions.assertTrue(hand1.winsOver(hand2));
    }

    @Test
    void DoublePairShouldWinAgainstHighCard() {
        Hand hand1 = new Hand("AC", "AH", "2C", "2D", "6D");
        Hand hand2 = new Hand("KD", "QC", "9D", "8S", "7S");
        Assertions.assertTrue(hand1.winsOver(hand2));
    }

    @Test
    void PairShouldLoseAgainstDoublePair() {
        Hand hand1 = new Hand("QD", "QC", "9D", "8S", "7S");
        Hand hand2 = new Hand("AC", "AH", "2C", "2D", "6D");
        Assertions.assertFalse(hand1.winsOver(hand2));
    }

    @Test
    void PairOfKingsShouldWinAgainstPairOfQueens() {
        Hand hand1 = new Hand("KD", "KC", "9D", "8S", "7S");
        Hand hand2 = new Hand("QC", "QH", "3C", "2D", "6D");
        Assertions.assertTrue(hand1.winsOver(hand2));
    }

    @Test
    void PairsOfKingsAndQueensShouldWinAgainstPairOfKingsAndJacks() {
        Hand hand1 = new Hand("7C", "7H", "KH", "KS", "2D");
        Hand hand2 = new Hand("KD", "KC", "6D", "6S", "QS");
        Assertions.assertTrue(hand1.winsOver(hand2));
    }

    @Test
    void HigherColorShouldWinAgainstLowerColor() {
        Hand hand1 = new Hand("7C", "QC", "JC", "10C", "9C");
        Hand hand2 = new Hand("JD", "QD", "10D", "6D", "9D");
        Assertions.assertTrue(hand1.winsOver(hand2));
    }

    // TODO high card vs high card
}
