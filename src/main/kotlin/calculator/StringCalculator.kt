package calculator

import calculator.expression.StringExpression
import calculator.expression.StringExpressionTokenFactory

class StringCalculator(
    private val stringExpressionTokenFactory: StringExpressionTokenFactory
) {
    fun calculate(expression: StringExpression): Int {
        val tokens = expression.tokenize()

        val firstNumber = stringExpressionTokenFactory.createStringExpressionOperand(
            operand = tokens.first()
        )

        return tokens
            .drop(1)
            .chunked(2)
            .fold(firstNumber) { acc, cur ->
                val number2 = stringExpressionTokenFactory.createStringExpressionOperand(cur[1])
                val operator = stringExpressionTokenFactory.createStringExpressionOperator(cur[0])

                operator.apply(
                    number1 = acc,
                    number2 = number2
                )
            }
            .number
    }
}
