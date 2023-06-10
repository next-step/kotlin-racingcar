package calculator

import java.math.BigDecimal

object InfixCalculator {
    private val parser: InfixExpressionParser = InfixExpressionParser()
    private val stringFormatter: StringFormatter = StringFormatter()

    fun calculate(expression: String?): BigDecimal {
        val expressionWithoutSpace = stringFormatter.eraseWhiteSpace(expression)
        val infixExpression = parser.parse(expressionWithoutSpace)
        return infixExpression.operate()
    }
}
