package calculator

object ExpressionParser {
    private const val DELIMITER = " "

    fun parse(expression: String) = expression.split(DELIMITER).filter { it.isNotBlank() }
}
