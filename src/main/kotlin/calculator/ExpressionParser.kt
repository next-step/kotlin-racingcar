package calculator

object ExpressionParser {
    fun parse(expression: String): List<ExpressionElement> {
        val splits = expression.split(" ")

        return splits.map {
            it.toExpression()
        }
    }

    private fun String.toExpression(): ExpressionElement {
        val digit = this.toIntOrNull()

        return digit
            ?.let { ExpressionElement.Term(it) }
            ?: ExpressionElement.Operator.find(this)
    }
}
