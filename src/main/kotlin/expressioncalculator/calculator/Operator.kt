package expressioncalculator.calculator

enum class Operator(
    val symbol: String,
    val operate: (num1: Double, num2: Double) -> Double
) {
    PLUS(Operator.SYMBOL_PLUS, { num1, num2 ->
        num1 + num2
    }),
    MINUS(Operator.SYMBOL_MINUS, { num1, num2 ->
        num1 - num2
    }),
    MULTIPLY(Operator.SYMBOL_MULTIPLY, { num1, num2 ->
        num1 * num2
    }),
    DIVIDE(Operator.SYMBOL_DIVIDE, { num1, num2 ->
        require(num2 != 0.0) {
            Operator.DIVIDED_BY_ZERO_ERROR_MESSAGE
        }
        num1 / num2
    });

    companion object {
        const val SYMBOL_PLUS = "+"
        const val SYMBOL_MINUS = "-"
        const val SYMBOL_MULTIPLY = "*"
        const val SYMBOL_DIVIDE = "/"

        private const val INVALID_SYMBOL_ERROR_MESSAGE = "사칙 연산 기호가 아닌 값이 전달되었습니다."
        const val DIVIDED_BY_ZERO_ERROR_MESSAGE = "0으로는 나눌 수 없습니다."

        @Throws(IllegalArgumentException::class)
        fun from(symbol: String) = values().find { operator ->
            operator.symbol == symbol
        } ?: throw IllegalArgumentException(INVALID_SYMBOL_ERROR_MESSAGE)
    }
}
