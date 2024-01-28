package com.example.vg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {
    private Game game;

    @BeforeEach()
    void init() {
        game = new Game();
    }

    @Test
    @DisplayName("On one roll return score")
    void onOneRollReturnScore() {
        setHardRolls(1, 10);
        assertThat(game.score()).as("Return 10").isEqualTo(10);
    }

    @Test
    @DisplayName("On two rolls return sum of this rolls")
    void onTwoRollsReturnSumOfThisRolls() {
        setCustomRolls(3, 2);
        assertThat(game.score()).as("Return 5").isEqualTo(5);
    }

    @Test
    @DisplayName("Throw error on negative numbers")
    void throwErrorOnNegativeNumbers() {
        setCustomRolls(10, -5, -4);
        assertThatThrownBy(game::score).isInstanceOf(IllegalArgumentException.class).hasMessage("Negatives not allowed");
    }

    @Test
    @DisplayName("Throw exception when points execl 10")
    void throwExceptionWhenPointsExecl10() {
        setHardRolls(1, 11);
        assertThatThrownBy(game::score).isInstanceOf(IllegalArgumentException.class).hasMessage("More than 10 pins per roll not allowed");
    }

    @Test
    @DisplayName("on 10 Pinns assure it a strike")
    void on10PinnsAssureItAStrike() {
        setHardRolls(12, 10);
        assertThat(game.score()).as("Hdcp Score 300").isEqualTo(300);
    }

    @Test
    @DisplayName("Assure it spare")
    void assureItSpare() {
        setHardRolls(21, 5);

        assertThat(game.score()).as("Hdcp Score 150").isEqualTo(150);
    }


    @Test
    @DisplayName("Assure that full game is working")
    void assureThatFullGameIsWorking() {
        setCustomRolls(10, 3, 2, 5, 5, 3, 2, 5, 4, 2, 1, 0, 0, 6, 4, 2, 4, 10, 8, 2);
        assertThat(game.score()).as("Hdcp score 88").isEqualTo(88);
    }

    private void setHardRolls(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

    private void setCustomRolls(int... pins) {
        for (int pin : pins) {
            game.roll(pin);
        }
    }
}