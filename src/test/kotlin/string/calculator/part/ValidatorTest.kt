package string.calculator.part

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import string.calculator.domain.Operator
import string.calculator.domain.UserInterface

internal class ValidatorTest {
    @Test
    fun `숫자가 입력되지 않으면 예외를 발생시킨다`() {
        val numbers = mutableListOf<Long>()

        assertThrows<IllegalArgumentException> {
            UserInterface.validateInput(numbers, mutableListOf(Operator.PLUS))
        }
    }

    @Test
    fun `연산자가 입력되지 않으면 예외를 발생시킨다`() {
        val operators = mutableListOf<Operator>()

        assertThrows<IllegalArgumentException> {
            UserInterface.validateInput(mutableListOf(1L), operators)
        }
    }

    @Test
    fun `숫자가 하나만 입력되면 예외를 발생시킨다`() {
        val numbers = mutableListOf(1L)
        val operators = mutableListOf(Operator.PLUS)

        assertThrows<IllegalArgumentException> {
            UserInterface.validateInput(numbers, operators)
        }
    }

    @Test
    fun `입력값이 올바르지 않으면 예외를 발생시킨다`() {
        val numbers = mutableListOf(1L, 2L)
        val operators = mutableListOf(Operator.PLUS, Operator.MINUS)

        assertThrows<IllegalArgumentException> {
            UserInterface.validateInput(numbers, operators)
        }
    }

    @Test
    fun `Y 또는 N이 아닌 값이 입력되면 예외를 발생시킨다`() {
        val input = "a"

        assertThrows<IllegalArgumentException> {
            UserInterface.validateContinue(input)
        }
    }
}
