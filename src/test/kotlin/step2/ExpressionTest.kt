package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class ExpressionTest {
    @Test
    fun `단순 식 계산 테스트`() {
        val expression = Expression(
            number = 2,
            calculator = MinusCalculator(),
            nextExpression = null
        )
        val firstNumber = 10

        val result = expression.execute(firstNumber)

        assertThat(result).isEqualTo(8)
    }

    @Test
    fun `복합 식 계산 테스트`() {
        val lastExpression = Expression(
            number = 2,
            calculator = DivisionCalculator(),
            nextExpression = null
        )
        val secondExpression = Expression(
            number = 4,
            calculator = MultipleCalculator(),
            nextExpression = lastExpression
        )
        val firstExpression = Expression(
            number = 3,
            calculator = PlusCalculator(),
            nextExpression = secondExpression
        )
        val firstNumber = 2

        val result = firstExpression.execute(firstNumber)

        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `계산 중 인자 오류 테스트`() {
        val expression = Expression(
            number = 10,
            calculator = DivisionCalculator(),
            nextExpression = null
        )
        val firstNumber = 2

        assertThatThrownBy {
            expression.execute(firstNumber)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
