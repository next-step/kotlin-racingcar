package calculator

import isOdd

object InputValidator {
    private const val MIN_EXPRESSION_SIZE = 3

    fun isValidExpression(expression: List<String>) =
        checkExpressionSize(expression) && hasValidOperand(expression) && hasValidOperator(expression)

    private fun checkExpressionSize(expression: List<String>) =
        expression.size >= MIN_EXPRESSION_SIZE && expression.size.isOdd()

    private fun hasValidOperand(expression: List<String>) =
        expression.filterIndexed { index, _ -> !index.isOdd() }.all { InputType.of(it) == InputType.NUMBER }

    private fun hasValidOperator(expression: List<String>) =
        expression.filterIndexed { index, _ -> index.isOdd() }.all { InputType.of(it) == InputType.OPERATOR }
}
