package step2

private const val OPERATOR_ERROR_MESSAGE = "올바른 사칙연산 기호를 입력해주세요."

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
        return operation(x, y)
    }
}
