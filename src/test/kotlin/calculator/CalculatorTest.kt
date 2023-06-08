package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @Test
    fun `덧셈`() {
        // given
        val left = 10
        val right = 10
        val expression = "$left + $right"

        // when
        val result = Calculator.calculate(expression)

        // then
        assertThat(result).isEqualTo(20)
    }

    @Test
    fun `뺄셈`() {
        // given
        val left = 20
        val right = 10
        val expression = "$left - $right"

        // when
        val result = Calculator.calculate(expression)

        // then
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `곱셈`() {
        // given
        val left = 10
        val right = 10
        val expression = "$left * $right"

        // when
        val result = Calculator.calculate(expression)

        // then
        assertThat(result).isEqualTo(100)
    }

    @Test
    fun `나눗셈`() {
        // given
        val left = 20
        val right = 10
        val expression = "$left / $right"

        // when
        val result = Calculator.calculate(expression)

        // then
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `나눗셈 - 0으로 나누는 경우 예외`() {
        // given
        val left = 20
        val right = 0
        val expression = "$left / $right"

        // expect
        assertThrows<IllegalArgumentException> { Calculator.calculate(expression) }
    }

    @Test
    fun `사칙연산`() {
        // given
        val expression = "2 + 3 * 4 / 2 - 5"

        // when
        val result = Calculator.calculate(expression)

        // then
        assertThat(result).isEqualTo(5)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 & 1", "1 1 1", "1   1"])
    fun `연산자에 사칙연산이 아닌 문자가 포함된 경우 예외`(invalidExpression: String) {
        // expect
        assertThrows<IllegalArgumentException> { Calculator.calculate(invalidExpression) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["& + 1", "  + 1", "   1"])
    fun `피연산자에 숫자가 아닌 문자가 포함된 경우 예외`(invalidExpression: String) {
        // expect
        assertThrows<IllegalArgumentException> { Calculator.calculate(invalidExpression) }
    }

    @Test
    fun `null이 입력되는 경우 예외`() {
        // given
        val expression = null

        // expect
        assertThrows<IllegalArgumentException> { Calculator.calculate(expression) }
    }

    @Test
    fun `공백이 입력되는 경우 예외`() {
        // given
        val expression = " "

        // expect
        assertThrows<IllegalArgumentException> { Calculator.calculate(expression) }
    }
}
