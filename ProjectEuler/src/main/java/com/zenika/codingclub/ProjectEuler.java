package com.zenika.codingclub;

import java.util.stream.IntStream;

public class ProjectEuler {

    public static void main(String[] args) {
        System.out.println(IntStream.range(1, 1000)
                .filter(ProjectEuler::isMultipleOf3Or5)
                .sum());
    }

    private static boolean isMultipleOf3Or5(int number) {
        return number % 3 == 0 || number % 5 == 0;
    }

}
