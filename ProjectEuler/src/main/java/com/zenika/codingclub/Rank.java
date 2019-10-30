package com.zenika.codingclub;

import java.util.List;

public class Rank implements Comparable<Rank> {

    private int category;
    private List<Integer> categoryCardRanks;
    private List<Integer> kickers;

    public Rank(int category, List<Integer> categoryCardRanks, List<Integer> kickers) {
        this.category = category;
        this.categoryCardRanks = categoryCardRanks;
        this.kickers = kickers;
    }

    @Override
    public int compareTo(Rank other) {
        if (this.category > other.category) {
            return 1;
        } else if (this.category == other.category) {
            return compareCategoryCardRanks(this.categoryCardRanks, other.categoryCardRanks);
        } else {
            return -1;
        }
    }

    private int compareCategoryCardRanks(List<Integer> categoryCardRanks1, List<Integer> categoryCardRanks2) {
        for (int i = 0; i < categoryCardRanks1.size(); i++) {
            if (categoryCardRanks1.get(i) > categoryCardRanks2.get(i)) {
                return 1;
            } else if (categoryCardRanks1.get(i) < categoryCardRanks2.get(i)) {
                return -1;
            }
        }
        return 0;
    }
}
