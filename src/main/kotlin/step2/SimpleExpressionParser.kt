package step2

class SimpleExpressionParser : ExpressionParser {

    override fun parse(expression: String): Expression {
        validateExpression(expression)

        val tokenizedExpression = tokenizeExpression(expression)

        val operands: MutableList<Int> = mutableListOf()
        for (i in 0 until tokenizedExpression.size step 2) {
            val token = tokenizedExpression[i]
            operands.add(token.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다 [$token]"))
        }

        val operators: MutableList<Operator> = mutableListOf()
        for (i in 1 until tokenizedExpression.size step 2) {
            val token = tokenizedExpression[i]
            operators.add(Operator.bySymbol(token) ?: throw IllegalArgumentException("지원하지 않는 연산자 기호가 포함되어 있습니다 [$token]"))
        }

        require(operands.size == operators.size + 1) { "operand 개수는 항상 operator 보다 1개 더 많아야 합니다" }

        return Expression(operands, operators)
    }

    private fun validateExpression(expression: String) {
        require(expression.isNotBlank())
        require(expression.isNotEmpty())
    }

    private fun tokenizeExpression(expression: String): List<String> {
        val simpleSpaceDelimiter = " "
        return expression.trim().split(simpleSpaceDelimiter)
    }
}
