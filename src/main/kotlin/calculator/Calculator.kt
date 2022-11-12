package calculator

class Calculator {
    fun calculate(expression: String?): Int {
        checkNullOrBlank(expression)
        val tokens = parseExpression(expression!!)
        checkIncompleteExpression(tokens)
        return calculateWithTokens(tokens)
    }

    private fun checkNullOrBlank(expression: String?) {
        require(expression != null) { "expression is null" }
        require(expression.isNotBlank()) { "expression is blank" }
    }

    private fun parseExpression(expression: String): List<String> = expression.split(SPLIT_EXPRESSION_DELIMITER)

    private fun checkIncompleteExpression(tokens: List<String>) {
        if (tokens.size % INCOMPLETE_EXPRESSION_STANDARD == 0) {
            throw IllegalArgumentException("expression is not completed")
        }
    }

    private fun calculateWithTokens(tokens: List<String>): Int {
        var result = Operand.of(tokens[0]).value
        for (i in 1 until tokens.size step INCOMPLETE_EXPRESSION_STANDARD) {
            val operand = Operator.of(tokens[i])
            val right = Operand.of(tokens[i + 1])
            result = operand.calculate(result, right.value)
        }
        return result
    }

    companion object {
        private const val SPLIT_EXPRESSION_DELIMITER = " "
        private const val INCOMPLETE_EXPRESSION_STANDARD = 2
    }
}
