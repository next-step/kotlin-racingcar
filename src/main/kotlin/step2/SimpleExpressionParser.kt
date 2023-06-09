package step2

class SimpleExpressionParser : ExpressionParser {

    private val operands: MutableList<Int> = mutableListOf()
    private val operators: MutableList<Operator> = mutableListOf()

    override fun parse(expression: String) {
        resetParser()

        validateExpression(expression)
        val tokenizedExpression = tokenizeExpression(expression)

        for (i in 0..tokenizedExpression.lastIndex step 2) {
            val token = tokenizedExpression[i]
            val operand = token.toIntOrNull()
            requireNotNull(operand)
            require(!(operators.lastOrNull() == Operator.DIVIDE && operand == 0)) { "divide by zero" }
            operands.add(operand)
        }

        for (i in 1..tokenizedExpression.lastIndex step 2) {
            val token = tokenizedExpression[i]
            val operator = Operator.bySymbol(token)
            requireNotNull(operator)
            require(i != tokenizedExpression.lastIndex) { "end with operator" }

            operators.add(operator)
        }
    }

    private fun validateExpression(expression: String) {
        require(expression.isNotBlank())
        require(expression.isNotEmpty())
    }

    private fun validateTokenizedExpression(tokens: List<String>) {
    }

    private fun isNumberIndex(index: Int): Boolean = index % 2 == 0

    private fun tokenizeExpression(expression: String): List<String> {
        return expression.trim().split(" ")
    }

    override fun getOperandsInOrder(): List<Int> {
        check(operands.size > 0) { "parsing 된 expression이 없습니다." }
        return operands.toList()
    }

    override fun getOperatorInOrder(): List<Operator> {
        check(operators.size > 0) { "parsing 된 expression이 없습니다." }
        return operators.toList()
    }

    private fun resetParser() {
        operands.clear()
        operators.clear()
    }
}
