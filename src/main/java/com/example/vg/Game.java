package com.example.vg;

public class Game implements Gaming {
    private final int frames = 10;
    private int score = 0;

    @Override
    public void roll(int pins) {
        score += pins;
    }

    @Override
    public int score() {

        return score;
    }
}
