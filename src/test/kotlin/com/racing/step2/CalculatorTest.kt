package com.racing.step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {
    @ParameterizedTest
    @CsvSource(
        "3 + 4 - 1 / 3 + 5,  7",
        "3 + 13 / 2 + 5,  13",
        "5 - 1 * 6 - 2,  22",
        "6 * 7 / 2 + 1, 22"
    )
    fun `성공하는 계산 케이스`(input: String, answer: Int) {
        // when
        val calculator = Calculator()
        val result = calculator.exec(input)

        // then
        assertThat(result).isEqualTo(answer)
    }

    @Test
    fun `0 으로는 나눌 시 예외`() {
        // given
        val input = "3 + 10 - 1 / 0 + 5"

        // when
        val calculator = Calculator()

        // then
        assertThrows<IllegalArgumentException> {
            calculator.exec(input)
        }
    }

    @Test
    fun `입력값이 null이거나 빈 공백 문자일 경우 예외`() {
        // given
        val input = ""
        val input2 = " "

        // when
        val calculator = Calculator()

        // then
        assertThrows<IllegalArgumentException> {
            calculator.exec(input)
        }

        assertThrows<IllegalArgumentException> {
            calculator.exec(input2)
        }
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 예외`() {
        // given
        val input = "intput string"

        // when
        val calculator = Calculator()

        // then
        assertThrows<IllegalArgumentException> {
            calculator.exec(input)
        }
    }
}
