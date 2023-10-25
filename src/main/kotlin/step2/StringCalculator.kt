package step2

object StringCalculator {
    private const val PLUS = "+"
    private const val MINUS = "-"
    private const val MULTIPLY = "*"
    private const val DIVIDE = "/"
    const val UNSUPPORTED_OPERATOR_MSG = "지원하지 않는 연산자입니다."

    fun applyOperation(currentResult: Int, nextValue: Int, operation: String): Int {
        return when (operation) {
            PLUS -> currentResult + nextValue
            MINUS -> currentResult - nextValue
            MULTIPLY -> currentResult * nextValue
            DIVIDE -> currentResult / nextValue
            else -> throw IllegalArgumentException(UNSUPPORTED_OPERATOR_MSG)
        }
    }
}
