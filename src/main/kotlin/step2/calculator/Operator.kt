package step2.calculator

enum class Operator(
    val symbol: String,
    val operate: (num1: Double, num2: Double) -> Double
) {
    PLUS("+", { num1, num2 ->
        num1 + num2
    }),
    MINUS("-", { num1, num2 ->
        num1 - num2
    }),
    MULTIPLY("*", { num1, num2 ->
        num1 * num2
    }),
    DIVIDE("/", { num1, num2 ->
        num1 / num2
    });

    companion object {
        const val SYMBOL_PLUS = "+"
        const val SYMBOL_MINUS = "-"
        const val SYMBOL_MULTIPLY = "*"
        const val SYMBOL_DIVIDE = "/"

        private const val INVALID_SYMBOL_ERROR_MESSAGE = "사칙 연산 기호가 아닌 값이 전달되었습니다."

        fun from(symbol: String) = values().find { operator ->
            operator.symbol == symbol
        } ?: throw IllegalArgumentException(INVALID_SYMBOL_ERROR_MESSAGE)
    }
}