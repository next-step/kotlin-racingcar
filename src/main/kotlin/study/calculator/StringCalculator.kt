package study.calculator

import study.calculator.Expression.Companion.convertToExpressions
import study.util.requireNotNullOrBlank

object StringCalculator {
    fun calculate(input: String?): String =
        input
            .requireNotNullOrBlank() { "Input value cannot be null or blank" }
            .let { convertToExpressions(it) }
            .fold(0) { result, expression -> expression.operator.evaluate(result, expression.number) }
            .toString()
}
