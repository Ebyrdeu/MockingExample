package com.example.vg;

public class Game implements Gaming {
    private final int FRAMES = 10;
    private final int[] totalRolls = new int[21];
    private int currentRoll = 0;

    private int currentScore = 0;

    @Override
    public void roll(int pins) {
        totalRolls[currentRoll++] = pins;
    }

    @Override
    public int score() {
        int frame = 0;
        for (int roll : totalRolls) {
            if (roll < 0) throw new IllegalArgumentException("Negatives not allowed");
            if (roll > 10) throw new IllegalArgumentException("More than 10 pins per roll not allowed");
        }

        for (int i = 0; i < FRAMES; i++) {
            if (isStrike(frame)) {
                currentScore += 10 + strikeBonus(frame);
                frame++;
            }
            else {
                currentScore += totalRolls[frame];
                frame++;
            }
        }


        return currentScore;
    }
    private int strikeBonus(int frame) {
        return totalRolls[frame + 1] + totalRolls[frame + 2];
    }
    private boolean isStrike(int frame) {
        return totalRolls[frame] == 10;
    }
}
