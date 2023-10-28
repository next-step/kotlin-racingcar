package calculator

import calculator.expression.StringExpression
import calculator.expression.StringExpressionTokenFactory

fun main() {
    val stringExpressionTokenFactory = StringExpressionTokenFactory()
    val calculator = StringCalculator(
        stringExpressionTokenFactory = stringExpressionTokenFactory
    )

    val input = readlnOrNull()
    val expression = StringExpression(input)
    val result = calculator.calculate(expression)

    println(result)
}
