package com.example.vg;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {
    private final Game game = new Game();

    @Test
    @DisplayName("On one roll return score")
    void onOneRollReturnScore() {
        game.roll(10);
        assertThat(game.score()).as("Return 10").isEqualTo(10);
    }

    @Test
    @DisplayName("On two rolls return sum of this rolls")
    void onTwoRollsReturnSumOfThisRolls() {
        game.roll(3);
        game.roll(2);

        assertThat(game.score()).as("Return 5").isEqualTo(5);
    }

    @Test
    @DisplayName("Throw error on negative numbers")
    void throwErrorOnNegativeNumbers() {
        game.roll(10);
        game.roll(-5);
        game.roll(-4);

        assertThatThrownBy(game::score).isInstanceOf(IllegalArgumentException.class).hasMessage("Negatives not allowed");
    }
}