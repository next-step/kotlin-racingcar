package string.calculator.part

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import string.calculator.domain.Calculator
import string.calculator.domain.Operator
import string.calculator.domain.UserInterface

internal class ValidatorTest {
    @Test
    fun `숫자가 입력되지 않으면 예외를 발생시킨다`() {
        val numbers = mutableListOf<Long>()
        val operators = mutableListOf(Operator.PLUS)

        assertThatThrownBy { Calculator(numbers, operators) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Calculator.NUMBER_NOT_ENTERED)
    }

    @Test
    fun `연산자가 입력되지 않으면 예외를 발생시킨다`() {
        val operators = mutableListOf<Operator>()
        val numbers = mutableListOf(1L)

        assertThatThrownBy { Calculator(numbers, operators) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Calculator.OPERATOR_NOT_ENTERED)
    }

    @Test
    fun `숫자가 하나만 입력되면 예외를 발생시킨다`() {
        val numbers = mutableListOf(1L)
        val operators = mutableListOf(Operator.PLUS)

        assertThatThrownBy { Calculator(numbers, operators) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Calculator.OPERAND_COUNT_MISMATCH)
    }

    @Test
    fun `입력값이 올바르지 않으면 예외를 발생시킨다`() {
        val numbers = mutableListOf(1L, 2L)
        val operators = mutableListOf(Operator.PLUS, Operator.MINUS)

        assertThatThrownBy { Calculator(numbers, operators) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Calculator.INPUT_IS_NOT_VALID)
    }

    @Test
    fun `Y 또는 N이 아닌 값이 입력되면 예외를 발생시킨다`() {
        val input = "a"

        assertThrows<IllegalArgumentException> {
            UserInterface.validateContinue(input)
        }
    }
}
