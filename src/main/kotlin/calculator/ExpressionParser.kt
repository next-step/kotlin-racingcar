package calculator

import java.lang.IllegalArgumentException

class ExpressionParser {
    fun parse(expression: String): List<ExpressionElement> {
        val splits = expression.split(" ")

        return splits.map {
            it.toExpression()
        }
    }

    private fun String.toExpression(): ExpressionElement {
        val isDigit = all { it.isDigit() }

        if (isDigit) {
            return ExpressionElement.Term(toInt())
        }

        return when (this) {
            "+" -> ExpressionElement.Operator.Add
            "-" -> ExpressionElement.Operator.Sub
            "*" -> ExpressionElement.Operator.Multi
            "/" -> ExpressionElement.Operator.Div

            else -> throw IllegalArgumentException("Not supported operator")
        }
    }
}
