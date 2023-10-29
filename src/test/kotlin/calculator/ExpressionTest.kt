package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExpressionTest {

    @Test
    fun `left 필드 값이 없는 Expression 일 때, left 값이 없다면 IllegalArgumentException이 발생합니다`() {
        val expression: Expression = Expression(null, Operator.PLUS, 2)

        assertThrows<IllegalArgumentException> {
            expression.calculate()
        }
    }

    @Test
    fun `left 필드 값이 없는 Expression 일 때, left 값을 매개변수를 통해 전달받아 계산합니다`() {
        val expression: Expression = Expression(null, Operator.PLUS, 2)

        val result: Long = expression.calculate(1)

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `계산식을 계산합니다`() {
        val expression: Expression = Expression(1, Operator.PLUS, 2)

        val result: Long = expression.calculate()

        assertThat(result).isEqualTo(3)
    }
}
