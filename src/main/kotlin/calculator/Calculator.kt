package calculator

import calculator.utils.rawExpressionSplit

object Calculator {
    fun execute(rawExpression: String): Double {
        ExpressionValidator.validate(rawExpression)
        val computableExpression = convertComputableExpression(rawExpression)

        val calculateData = computableExpression
            .chunked(2)
            .map { (operator, operand) ->
                Operator.from(operator) to operand.toDouble()
            }

        return calculateData.fold(0.0) { acc, (operator, operand) ->
            operator(acc, operand)
        }
    }

    private fun convertComputableExpression(rawExpression: String): List<String> =
        listOf<String>("+").plus(rawExpression.rawExpressionSplit())
}
