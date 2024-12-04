package week1.calculator

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    private val calculator = Calculator()

    @ParameterizedTest
    @CsvSource(
        value = [
            "1 + 1=2",
            "2 + 2 + 2=6",
        ],
        delimiter = '=',
    )
    fun `덧셈`(
        input: String,
        expected: String,
    ) {
        assertEquals(input, expected)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1 - 1=0",
            "1 - 1 - 1=-1",
        ],
        delimiter = '=',
    )
    fun `뺄셈`(
        input: String,
        expected: String,
    ) {
        assertEquals(input, expected)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1 / 1=1",
            "8 / 4 / 2=1",
        ],
        delimiter = '=',
    )
    fun `나눗셈`(
        input: String,
        expected: String,
    ) {
        assertEquals(input, expected)
    }

    @Test
    fun `나눗셈 by Zero`() {
        assertThrows(ArithmeticException::class.java) { calculator.calculate("8 / 0") }
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "9 * 9=81",
            "2 * 2 * 2=8",
        ],
        delimiter = '=',
    )
    fun `곱셈`(
        input: String,
        expected: String,
    ) {
        assertEquals(input, expected)
    }

    @Test
    fun `{given} null 문자열 {when} calculate() {then} IllegalArgumentException 던짐`() {
        assertThatIllegalArgumentException()
            .isThrownBy { calculator.calculate(null) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "   "])
    fun `{given} blank 문자열 {when} calculate() {then} IllegalArgumentException 던짐`(input: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { calculator.calculate(input) }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1 & 3",
            "1 % 3",
        ],
    )
    fun `{given} 사칙연산 기호 포함되지 않은 문자열 {when} calculate() {then} IllegalArgumentException 던짐`(input: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { calculator.calculate(input) }
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1 + 2 / 2 * 3 / 3=1",
        ],
        delimiter = '=',
    )
    fun `{given} 사칙연산 모두 포함된 문자열 {when} calculate() {then} 연산자 등장 순서대로 계산함`(
        input: String,
        expected: String,
    ) {
        assertEquals(input, expected)
    }

    private fun assertEquals(
        input: String,
        expected: String,
    ) {
        val result = calculator.calculate(input)
        Assertions.assertEquals(expected, result)
    }
}
