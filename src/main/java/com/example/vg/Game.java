package com.example.vg;

public class Game implements Gaming {
    private final int[] totalRolls = new int[21] ;
    private int currentRoll = 0;
    @Override
    public void roll(int pins) {
        totalRolls[currentRoll++] = pins;
    }

    @Override
    public int score() {
        // max score is 300
        int score = 0;

        for (int roll : totalRolls) {
            if (roll < 0) throw new IllegalArgumentException("Negatives not allowed");
            score += roll;
        }

        return score;
    }
}
