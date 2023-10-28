package study.calculator

import study.calculator.Expression.Companion.convertToExpressions
import study.util.requireNotNullOrBlank

object StringCalculator {
    fun calculate(input: String?): String =
        input
            .requireNotNullOrBlank() { "Input value cannot be null or blank" }
            .toExpressions()
            .fold(0) { result, expression -> expression.operator.evaluate(result, expression.number) }
            .toString()

    private fun String.toExpressions() = convertToExpressions(this)
}
