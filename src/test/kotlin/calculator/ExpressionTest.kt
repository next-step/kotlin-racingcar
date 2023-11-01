package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExpressionTest {

    @Test
    fun `계산식을 계산합니다`() {
        val expression: Expression = Expression(1, Operator.PLUS, 2)

        val result: Long = expression.calculate()

        assertThat(result).isEqualTo(3)
    }
}
