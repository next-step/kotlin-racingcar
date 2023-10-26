package calculator

object StringCalculator {
    private const val PLUS = "+"
    private const val MINUS = "-"
    private const val MULTIPLY = "*"
    private const val DIVIDE = "/"

    fun applyOperation(currentResult: Int, nextValue: Int, operation: String): Int {
        return when (operation) {
            PLUS -> currentResult + nextValue
            MINUS -> currentResult - nextValue
            MULTIPLY -> currentResult * nextValue
            DIVIDE -> currentResult / nextValue
            else -> throw IllegalArgumentException(ErrorMessage.UNSUPPORTED_OPERATOR_MSG.message)
        }
    }
}
