package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class CalculatorTest {
    @DisplayName("계산기 테스트")
    @Test
    fun calculate() {
        val calculator = Calculator()
        val input = listOf("4", "+", "4", "/", "2", "*", "2")
        val calcValue = calculator.calculate(input)

        assertThat(calcValue).isEqualTo(8.0)
    }

    @DisplayName("계산기 테스트(단일 숫자 입력)")
    @Test
    fun calculateOnlyOneParameter() {
        val calculator = Calculator()
        val inputOne = listOf("4")
        val oneValue = calculator.calculate(inputOne)
        assertThat(oneValue).isEqualTo(4.0)
    }

    @DisplayName("계산기 테스트(단일 숫자 & 단일 연산자 입력)")
    @Test
    fun calculateOnlyTwoParameter() {
        val calculator = Calculator()
        val inputTwo = listOf("4", "-")
        val twoValue = calculator.calculate(inputTwo)
        assertThat(twoValue).isEqualTo(4.0)
    }

    @DisplayName("계산기 비 정상 테스트")
    @Test
    fun calculateExcept() {
        val calculator = Calculator()
        val inputOperate = listOf("+")
        assertThrows<IllegalArgumentException> {
            calculator.calculate(inputOperate)
        }
    }
}
