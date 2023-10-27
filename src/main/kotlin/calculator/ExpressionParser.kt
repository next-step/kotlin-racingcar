package calculator

import java.lang.IllegalArgumentException

class ExpressionParser {
    fun parse(expression: String?): List<ExpressionType> {
        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException("Expression cannot be null or blank")
        }

        val splits = expression.split(" ")

        return splits.map {
            it.toExpression()
        }
    }

    private fun String.toExpression(): ExpressionType {
        val isDigit = all { it.isDigit() }

        if (isDigit) {
            return ExpressionType.Term(toInt())
        }

        return when (this) {
            "+" -> ExpressionType.Operator.Add
            "-" -> ExpressionType.Operator.Sub
            "*" -> ExpressionType.Operator.Multi
            "/" -> ExpressionType.Operator.Div

            else -> throw IllegalArgumentException("Not supported operator")
        }
    }
}
