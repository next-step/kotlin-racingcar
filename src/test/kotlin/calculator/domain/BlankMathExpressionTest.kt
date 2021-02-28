package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class BlankMathExpressionTest {

    @Test
    fun `연산자와 피연산자를 구분한다`() {
        // given
        val input = "1 + 2 - 3 * 4 / 5"
        val mathExpression = BlankMathExpression(input)

        val expectedOperands = listOf(Number(1), Number(2), Number(3), Number(4), Number(5))
        val expectedOperators = listOf(Operator.PLUS, Operator.MINUS, Operator.MULTIPLE, Operator.DIVIDE)

        // when
        val operands = mathExpression.extractOperands()
        val operators = mathExpression.extractOperators()

        // then
        assertAll(
            { assertThat(operands).isEqualTo(expectedOperands) },
            { assertThat(operators).isEqualTo(expectedOperators) }
        )
    }
}
