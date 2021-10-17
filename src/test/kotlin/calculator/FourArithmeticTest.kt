package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class FourArithmeticTest {

    @ParameterizedTest
    @CsvSource("2 3 5", "-1 -4 -5", "-5 8 3", delimiter = ' ')
    fun 더하기(firstValue: Int, secondValue: Int, result: Int) {
        assertThat(FourArithmetic.PLUS.apply(firstValue, secondValue)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource("5 2 3", "-3 -2 -1", "5 5 0", delimiter = ' ')
    fun 빼기(firstValue: Int, secondValue: Int, result: Int) {
        assertThat(FourArithmetic.MINUS.apply(firstValue, secondValue)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource("5 2 10", "3 -2 -6", "5 0 0", delimiter = ' ')
    fun 곱하기(firstValue: Int, secondValue: Int, result: Int) {
        assertThat(FourArithmetic.MULTIPLY.apply(firstValue, secondValue)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource("6 2 3", "8 -2 -4", "5 1 5", delimiter = ' ')
    fun 나누기(firstValue: Int, secondValue: Int, result: Int) {
        assertThat(FourArithmetic.DIVISION.apply(firstValue, secondValue)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource("0 5", "5 0", delimiter = ' ')
    fun `0 으로 나누기 예외`(firstValue: Int, secondValue: Int) {
        assertThrows<ArithmeticException> {
            confirmFourArithmetic("/", Pair(firstValue, secondValue))
        }
    }

    @ParameterizedTest
    @CsvSource(value = ["@", "%", "$", "&"])
    fun `사칙연산 예외 기호`(arithmetic: String) {
        assertThrows<IllegalArgumentException> {
            confirmFourArithmetic(arithmetic, Pair(1, 2))
        }
    }
}
