package calculator.controller

import calculator.domain.Calculator
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorControllerTest {

    @CsvSource("1, +, 2, 3", "1, -, 2, -1", "4, *, 5, 20", "8, /, 2, 4")
    @ParameterizedTest
    fun `연산된 결과를 반환한다`(number1: String, operator: String, number2: String, expected: Int) {
        assertEquals(expected, CalculatorController(listOf(number1, operator, number2), Calculator()).getResult())
    }

    @Test
    fun `피연산자가 1개인 경우 그대로 반환한다`() {
        assertEquals(5, CalculatorController(listOf("5"), Calculator()).getResult())
    }

    @Test
    fun `첫 피연산자가 숫자가 아닌경우 예외를 던진다`() {
        assertThatThrownBy { CalculatorController(listOf("?", "+", "2"), Calculator()).getResult() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("피연산자는 숫자만 가능합니다.")
    }

    @Test
    fun `숫자와 연산자 사이가 공백으로 이뤄지지 않은 경우 예외를 던진다`() {
        assertThatThrownBy { CalculatorController(listOf("1", "-2"), Calculator()).getResult() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("숫자와 연산자 사이에는 공백이 있어야 합니다.")
    }

    @Test
    fun `피연산자를 입력하지 않은 경우 예외를 던진다`() {
        assertThatThrownBy { CalculatorController(listOf("1", "*"), Calculator()).getResult() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("반드시 연산하고자 하는 숫자를 입력해야 합니다.")
    }
}
