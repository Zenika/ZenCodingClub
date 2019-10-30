package com.zenika.codingclub;

import java.util.List;

@FunctionalInterface
public interface RankDetector {

    Rank detect(List<String> cards, List<Integer> cardRanks);
}
