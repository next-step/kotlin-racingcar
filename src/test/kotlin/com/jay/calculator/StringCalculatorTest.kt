package com.jay.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.lang.IllegalArgumentException

internal class StringCalculatorTest {
    @ParameterizedTest
    @MethodSource("malformedClientInputs")
    fun `적절하지 않은 input은 예외가 발생한다`(input: String?, errorMessage: String) {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            StringCalculator.calculate(input)
        }

        assertThat(exception.message).isEqualTo(errorMessage)
    }

    @ParameterizedTest
    @MethodSource("clientInputs")
    fun `사칙 연산 기호 기반으로 계산한다`(input: String?, expected: Int) {
        val actual = StringCalculator.calculate(input)

        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun malformedClientInputs() = listOf(
            Arguments.of(null, "input cannot be empty or null"),
            Arguments.of("", "input cannot be empty or null"),
            Arguments.of("1 $ 2", "invalid operand - $"),
            Arguments.of("1 ^ 2", "invalid operand - ^"),
            Arguments.of("1 + s", "invalid input - s"),
        )

        @JvmStatic
        fun clientInputs() = listOf(
            Arguments.of("1 + 2 + 4", 7),
            Arguments.of("1 - 2 - 3", -4),
            Arguments.of("1 * 2 * 3", 6),
            Arguments.of("1 / 2 / 3", 0),
            Arguments.of("1 + 2 * 3", 9),
            Arguments.of("1 - 2 / 3", 0),
        )
    }
}
