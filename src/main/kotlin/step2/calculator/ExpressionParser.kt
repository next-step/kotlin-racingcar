package step2.calculator

object ExpressionParser {
    private const val MINIMUM_EXPRESSION_LENGTH = 3
    private const val LESS_THAN_MINIMUM_EXPRESSION_LENGTH_ERROR_MESSAGE = "최소 두개의 항과 1개의 연산자를 입력하세요"
    private const val DELIMITER = " "

    fun parse(expression: String): List<String> {
        validateExpression(expression)
        return expression.split(DELIMITER)
    }

    private fun validateExpression(expression: String) {
        val expressionLength: Int = expression.trim().length
        require(expressionLength.overThan(MINIMUM_EXPRESSION_LENGTH)) { LESS_THAN_MINIMUM_EXPRESSION_LENGTH_ERROR_MESSAGE }
    }
}
