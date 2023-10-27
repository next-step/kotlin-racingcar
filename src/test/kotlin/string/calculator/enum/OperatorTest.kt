package string.calculator.enum

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import string.calculator.domain.Operator

internal class OperatorTest {
    @Test
    fun `연산자를 입력하면 해당 연산자를 반환한다`() {
        val inputs = listOf("+", "-", "*", "/")
        val operators = listOf(Operator.PLUS, Operator.MINUS, Operator.MULTIPLY, Operator.DIVIDE)

        inputs.forEachIndexed { index, input ->
            val result = Operator.of(input)

            assert(result == operators[index])
        }
    }

    @Test
    fun `지원하지 않는 연산자를 입력하면 예외를 발생시킨다`() {
        val input = "a"

        assertThrows<IllegalArgumentException> {
            Operator.of(input)
        }
    }
}
