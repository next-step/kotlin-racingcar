package calculator

import calculator.StringCalculator.Companion.add
import calculator.StringCalculator.Companion.calculate
import calculator.StringCalculator.Companion.divide
import calculator.StringCalculator.Companion.multiply
import calculator.StringCalculator.Companion.subtract
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource
import java.math.BigDecimal

class StringCalculatorTest {
    @Test
    fun `덧셈`() {
        val decimal1 = BigDecimal(1)
        val decimal2 = BigDecimal(2)

        val result = add(decimal1, decimal2)

        assertThat(result).isEqualTo(BigDecimal(3))
    }

    @Test
    fun `뺄셈`() {
        val decimal1 = BigDecimal(1)
        val decimal2 = BigDecimal(2)

        val result = subtract(decimal1, decimal2)

        assertThat(result).isEqualTo(BigDecimal(-1))
    }

    @Test
    fun `곱셈`() {
        val decimal1 = BigDecimal(3)
        val decimal2 = BigDecimal(7)

        val result = multiply(decimal1, decimal2)

        assertThat(result).isEqualTo(BigDecimal(21))
    }

    @ParameterizedTest
    @CsvSource(value = ["10:3:3", "10:3.00:3.33", "10.00:3:3.33", "100.0:20.0000:5.0000"], delimiter = ':')
    fun `나눗셈`(d1: BigDecimal, d2: BigDecimal, expected: BigDecimal) {
        assertThat(divide(d1, d2)).isEqualTo(expected)
    }

    @Test
    fun `0으로 나누기`() {
        val decimal1 = BigDecimal(1)
        val decimal2 = BigDecimal(0)

        assertThatThrownBy { divide(decimal1, decimal2) }
            .isInstanceOf(ArithmeticException::class.java)
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = [" ", "  ", "   "])
    fun `입력값 공백, 널 검증`(input: String) {
        assertThatThrownBy { calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "2 + + 3",
            "- 5 + 2",
            "1 1 2",
            "1 $ 2"
        ]
    )
    fun `사칙연산 기호 검증`(input: String) {
        assertThatThrownBy { calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "2 + 3 * 4 / 2:10",
            "5 * 10 / 5 / 2:5",
            "7 / 2 * 100 - 1:299"
        ], delimiter = ':'
    )
    fun `문자열 사칙연산`(input: String, expected: Int) {
        assertThat(calculate(input)).isEqualTo(expected)
    }
}
