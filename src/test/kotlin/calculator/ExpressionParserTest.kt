package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExpressionParserTest {

    private val expressionParser: ExpressionParser = ExpressionParser()

    @Test
    fun `계산식이 두개 이상이라면 계산식을 분리합니다 1`() {
        val input: String = "1 + 2 - 3"

        val result: List<Expression> = expressionParser.parse(input)

        val firstExpectedExpression: Expression = Expression(1, Operator.PLUS, 2)
        val secondExpectedExpression: Expression = Expression(null, Operator.MINUS, 3)
        assertThat(result).containsExactly(firstExpectedExpression, secondExpectedExpression)
    }

    @Test
    fun `계산식이 두개 이상이라면 계산식을 분리합니다 2`() {
        val input: String = "1 + 2 - 3 * 4"

        val result: List<Expression> = expressionParser.parse(input)

        val firstExpectedExpression: Expression = Expression(1, Operator.PLUS, 2)
        val secondExpectedExpression: Expression = Expression(null, Operator.MINUS, 3)
        val thirdExpectedExpression: Expression = Expression(null, Operator.MULTIPLY, 4)
        assertThat(result).containsExactly(firstExpectedExpression, secondExpectedExpression, thirdExpectedExpression)
    }
}
