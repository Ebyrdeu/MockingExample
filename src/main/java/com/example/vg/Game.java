package com.example.vg;

public class Game implements Gaming {
    private final int[] totalRolls = new int[21];
    private int currentRoll = 0;

    private int currentScore = 0;

    @Override
    public void roll(int pins) {
        totalRolls[currentRoll++] = pins;
    }

    @Override
    public int score() {
        int activeRoll = 0;
        int frames = 10;

        for (int i = 0; i < frames; i++) {
            if (totalRolls[activeRoll] > 10) throw new IllegalArgumentException("More than 10 pins per roll not allowed");
            if (totalRolls[activeRoll] < 0) throw new IllegalArgumentException("Negatives not allowed");

            if (isStrike(activeRoll)) {
                currentScore += 10 + strikeBonus(activeRoll);
                activeRoll++;
            } else if (isSpare(activeRoll)) {
                currentScore += 10 + spareBonus(activeRoll);
                activeRoll += 2;
            } else {
                currentScore += totalRolls[activeRoll] + totalRolls[activeRoll + 1];
                activeRoll += 2;
            }
        }

        return currentScore;
    }

    private int strikeBonus(int activeRoll) {
        return totalRolls[activeRoll + 1] + totalRolls[activeRoll + 2];
    }

    private boolean isStrike(int activeRoll) {
        return totalRolls[activeRoll] == 10;
    }

    private boolean isSpare(int activeRoll) {
        return totalRolls[activeRoll] + totalRolls[activeRoll + 1] == 10;
    }

    private int spareBonus(int activeRoll) {
        return totalRolls[activeRoll + 2];
    }
}
