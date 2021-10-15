package calculator

import calculator.StringExtension.checkNullOrEmpty
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest
    @CsvSource("2 + 4, 6.0", "27 + 31 + 11, 69.0", "30 + 21 + 65 + 49, 165.0")
    fun `덧셈 테스트`(input: String, result: String) {
        assertEquals(Calculator.calculate(input), result)
    }

    @ParameterizedTest
    @CsvSource("2 - 1, 1.0", "60 - 31 - 11, 18.0", "30 - 21 - 1 - 4, 4.0")
    fun `뺄셈 테스트`(input: String, result: String) {
        assertEquals(Calculator.calculate(input), result)
    }

    @ParameterizedTest
    @CsvSource("2 * 4, 8.0", "27 * 31 * 11, 9207.0", "30 * 21 * 65 * 49, 2006550.0")
    fun `곱셈 테스트`(input: String, result: String) {
        assertEquals(Calculator.calculate(input), result)
    }

    @ParameterizedTest
    @CsvSource("2 / 4, 0.5", "30 / 3 / 2, 5.0", "100 / 2 / 5 / 5, 2.0")
    fun `나눗셈 테스트`(input: String, result: String) {
        assertEquals(Calculator.calculate(input), result)
    }

    @ParameterizedTest
    @CsvSource("2 + 4 - 1 * 3 / 2, 7.5", "10 + 11 - 12 * 13 / 3, 39.0", "21 + 42 - 30 * 6 / 3, 66.0")
    fun `혼합 테스트`(input: String, result: String) {
        assertEquals(Calculator.calculate(input), result)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `입력값이 null 이거나 빈 공백 문자`(input: String) {
        assertTrue(input.checkNullOrEmpty())
    }

    @ParameterizedTest
    @ValueSource(strings = ["!", "@", "#", "$", "^"])
    fun `사칙연산 기호가 아닌 경우`(input: String) {
        assertThatThrownBy {
            Operator.getOperatorEnum(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
