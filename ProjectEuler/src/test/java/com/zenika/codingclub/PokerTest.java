package com.zenika.codingclub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PokerTest {

    @Test
    void PairShouldWinAgainstHighCard() {
        Hand hand1 = new Hand("1C 1H 2C 3C 6D");
        Hand hand2 = new Hand("QD KC 9D 8S 7S");
        Assertions.assertTrue(hand1.winsOver(hand2));
    }

    @Test
    void HighCardShouldLoseAgainstPair() {
        Hand hand1 = new Hand("1C 1H 2C 3C 6D");
        Hand hand2 = new Hand("QD KC 9D 8S 7S");
        Assertions.assertFalse(hand2.winsOver(hand1));
    }

    @Test
    void DoublePairShouldWinAgainstPair() {
        Hand hand1 = new Hand("1C 1H 2C 2D 6D");
        Hand hand2 = new Hand("QD QC 9D 8S 7S");
        Assertions.assertTrue(hand1.winsOver(hand2));
    }


}