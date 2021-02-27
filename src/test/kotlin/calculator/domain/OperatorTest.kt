package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class OperatorTest {

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(
        "0, 2, 2",
        "-5, 7, 2",
        "3, -4, -1",
        "-2, -5, -7"
    )
    fun `덧셈`(firstNumber: Int, secondNumber: Int, expected: Int) {
        val operator = Operator.ADD
        val result = operator.operate(firstNumber, secondNumber)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource(
        "3, 2, 1",
        "-5, 7, -12",
        "3, -4, 7",
        "-2, -5, 3"
    )
    fun `뺄셈`(firstNumber: Int, secondNumber: Int, expected: Int) {
        val operator = Operator.MINUS
        val result = operator.operate(firstNumber, secondNumber)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource(
        "3, 0, 0",
        "3, 2, 6",
        "-5, 7, -35",
        "3, -4, -12",
        "-2, -5, 10"
    )
    fun `곱셈`(firstNumber: Int, secondNumber: Int, expected: Int) {
        val operator = Operator.MULTIPLE
        val result = operator.operate(firstNumber, secondNumber)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource(
        "3, 2, 1",
        "-5, 7, 0",
        "3, -4, 0",
        "-5, -2, 2"
    )
    fun `나눗셈`(firstNumber: Int, secondNumber: Int, expected: Int) {
        val operator = Operator.DIVIDE
        val result = operator.operate(firstNumber, secondNumber)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `0으로 나누기를 하는 경우 ArithmeticException 예외 발생`() {
        val operator = Operator.DIVIDE
        val result = assertThrows<ArithmeticException> { operator.operate(3, 0) }
        assertThat(result.message).isEqualTo("/ by zero")
    }
}
