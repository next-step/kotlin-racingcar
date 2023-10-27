package calculator.expression

class StringExpressionOperator(
    private val operator: String
) {
    companion object {
        private const val PLUS = "+"
        private const val MINUS = "-"
        private const val MULTIPLY = "*"
        private const val DIVIDE = "/"
    }

    fun apply(
        number1: StringExpressionOperand,
        number2: StringExpressionOperand,
    ): StringExpressionOperand {
        return when (operator) {
            PLUS -> number1 + number2
            MINUS -> number1 - number2
            MULTIPLY -> number1 * number2
            DIVIDE -> number1 / number2
            else -> throw IllegalArgumentException("unknown operation type.")
        }
    }
}
