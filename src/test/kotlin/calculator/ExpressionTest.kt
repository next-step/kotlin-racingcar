package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExpressionTest {

    @Test
    fun `계산하기`() {
        val operands = mutableListOf(2, 3, 4, 2)
        val operators = mutableListOf("+", "*", "/")

        val result = Expression.calculate(operands, operators)

        assertThat(result).isEqualTo(10)
    }
}
