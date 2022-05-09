package com.brandonrachelski.stringkata.calculator;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class StringCalculatorTest {
    @InjectMocks
    StringCalculator stringCalculator;

    @Nested
    class add {
        @ParameterizedTest
        @NullAndEmptySource
        void shouldReturn0_whenCalledWithEmptyStringOrNull(String value) {
            int actual = stringCalculator.add(value);
            assertThat(actual, equalTo(0));
        }

        @Test
        void shouldAddNumbersThatAreCommaDelimited() {
            int actual = stringCalculator.add("1,2");
            assertThat(actual, equalTo(3));
        }

        @ParameterizedTest
        @CsvSource(value = {"1;2;3, 6", "4;0;5, 9", "2;3, 5", "1, 1"}, delimiter = ',')
        void shouldAllowAnUnknownAmountOfNumbers(String addition, String expected) {
            addition = addition.replace(";", ",");
            int actual = stringCalculator.add(addition);
            assertThat(actual, equalTo(Integer.parseInt(expected)));
        }

        @Test
        void shouldUseNewLineCharacterAsDelimiter() {
            int actual = stringCalculator.add("1\n2,3");
            assertThat(actual, equalTo(6));
        }

        @Test
        void shouldAllowCustomDelimiters() {
            int actual = stringCalculator.add(";\n1;2;3;4");
            assertThat(actual, equalTo(10));
        }

        @Test
        void shouldIgnoreNumbersAbove1000() {
            int actual = stringCalculator.add("1000,1001,1002,5");
            assertThat(actual, equalTo(1005));
        }

        @Test
        void shouldTrimWhiteSpaceFromNumbers() {
            int actual = stringCalculator.add("1, 11, 12,5");
            assertThat(actual, equalTo(29));
        }

        @Nested
        class NegativeNumbers {
            @Test
            void shouldThrowExceptionForNegativeNumbers() {
                IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("1,-2,3,4"));
                assertThat(exception.getMessage(), equalTo("Negatives not allowed"));
            }

            @Test
            void shouldReportNegativeNumbersInExceptionMessage_whenThereIsMoreThanOneNegativeNumber() {
                IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add("1,-2,3,-4"));
                assertThat(exception.getMessage(), equalTo("Negatives not allowed: [-2, -4]"));
            }
        }

    }

}
