package string.calculator.part

import org.junit.jupiter.api.Test
import string.calculator.domain.Calculator
import string.calculator.domain.Operator

internal class CalculatorTest {

    @Test
    fun `숫자와 연산자를 입력하면 계산 결과를 반환한다`() {
        val numbers = mutableListOf(1L, 2L, 1L, 4L, 5L)
        val operators = mutableListOf(Operator.PLUS, Operator.MINUS, Operator.MULTIPLY, Operator.DIVIDE)

        val result = Calculator.calculate(numbers, operators)

        assert(result == 1L)
    }
}
