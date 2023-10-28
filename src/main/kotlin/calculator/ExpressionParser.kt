package calculator

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

        return ExpressionElement.Operator.find(this)
    }
}
