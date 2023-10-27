package step2

private const val OPERATOR_ERROR_MESSAGE = "올바른 사칙연산 기호를 입력해주세요."
private const val DIVIDE_WITH_ZERO_ERROR_MESSAGE = "0으로 나눌 수는 없습니다."

enum class MathOperator(val symbol: String, val operation: (Int, Int) -> Int) {
    PLUS(symbol = "+", operation = { x, y -> x + y }),
    MINUS(symbol = "-", operation = { x, y -> x - y }),
    MULTIPLY(symbol = "*", operation = { x, y -> x * y }),
    DIVIDE(symbol = "/", operation = { x, y -> x / y });

    companion object {
        fun from(operator: String): MathOperator {
            return values().find { it.symbol == operator } ?: throw IllegalArgumentException(OPERATOR_ERROR_MESSAGE)
        }
    }

    fun calculate(x: Int, y: Int): Int {
        if (this == DIVIDE && y == 0) {
            throw IllegalArgumentException(DIVIDE_WITH_ZERO_ERROR_MESSAGE)
        }

        return operation(x, y)
    }
}
