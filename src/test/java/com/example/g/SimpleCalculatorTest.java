package com.example.g;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SimpleCalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new SimpleCalculator();
    }

    @Test
    @DisplayName("Assure that empty string return 0")
    void assureThatEmptyStringReturn0() {
        int result = calculator.add("");
        assertThat(result).as("Return 0").isEqualTo(0);
    }

    @Test
    @DisplayName("Assure that on string 1 return be 1 as int")
    void assureThatOnString1ReturnBe1AsInt() {
        int result = calculator.add("1");
        assertThat(result).as("Return 1").isEqualTo(1);
    }

    @Test
    @DisplayName("Assure thant on string 1,2 return be sum of 1 and 2")
    void assureThantOnString12ReturnBeSumOf1And2() {
        int result = calculator.add("1,2");
        assertThat(result).as("Return 3").isEqualTo(3);
    }

    @Test
    @DisplayName("Assure that method can handle an unknown amount of numbers")
    void assureThatMethodCanHandleAnUnknownAmountOfNumbers() {
        int result = calculator.add("1,2,3,4,5");
        assertThat(result).as("Return 15").isEqualTo(15);
    }

    @Test
    @DisplayName("Allow the Add method to handle new lines between numbers instead of commas")
    void allowTheAddMethodToHandleNewLinesBetweenNumbersInsteadOfCommas() {
        int result = calculator.add("1\n2,3");
        assertThat(result).as("Return 6").isEqualTo(6);
    }

    @Test
    @DisplayName("Support different delimiters")
    void supportDifferentDelimiters() {
        int result = calculator.add("//;\n1;2");
        assertThat(result).as("Return 3").isEqualTo(3);
    }

    @Test
    @DisplayName("Calling Add with Negative Number will throw an exception")
    void callingAddWithNegativeNumberWillThrowAnException() {

        assertThatThrownBy(() -> calculator.add("//;\n-1;2"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("negatives not allowed");
    }

    @Test
    @DisplayName("Numbers bigger than 1000 should be ignored")
    void numbersBiggerThan1000ShouldBeIgnored() {
        int result = calculator.add("//;\n1001;2");
        assertThat(result).as("Return 2").isEqualTo(2);
    }

    @Test
    @DisplayName("Delimiters can be of any length with the following format")
    void delimitersCanBeOfAnyLengthWithTheFollowingFormat() {
        int result = calculator.add("//[***]\n1***2***3");
        assertThat(result).as("Return 6").isEqualTo(6);
    }

    @Test
    @DisplayName("Allow multiple delimiters")
    void allowMultipleDelimiters() {
        int result = calculator.add("//[*][%]\n1*2%3");
        assertThat(result).as("Return 6").isEqualTo(6);
    }

    @Test
    @DisplayName("Make sure you can also handle multiple delimiters with length longer than one char")
    void makeSureYouCanAlsoHandleMultipleDelimitersWithLengthLongerThanOneChar() {

        int result = calculator.add("//[***][%%%][;;;]\n1***2%%%3;;;4");
        assertThat(result).as("Return 10").isEqualTo(10);
    }
}