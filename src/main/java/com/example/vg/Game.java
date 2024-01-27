package com.example.vg;

public class Game implements Gaming {
    private final int FRAMES = 10;
    private final int[] totalRolls = new int[21] ;
    private int currentRoll = 0;

    private int currentScore = 0;

    @Override
    public void roll(int pins) {
        totalRolls[currentRoll++] = pins;
    }

    @Override
    public int score() {
        for (int roll : totalRolls) {
            if (roll < 0 ) throw new IllegalArgumentException("Negatives not allowed");
            if (roll > 10) throw  new IllegalArgumentException("More than 10 pins per roll not allowed");
            currentScore += roll;
        }

        return currentScore;
    }

}
