package string.calculator.enum

import org.junit.jupiter.api.Test

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
}
