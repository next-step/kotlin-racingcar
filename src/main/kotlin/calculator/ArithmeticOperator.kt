package calculator

enum class ArithmeticOperator(
    private val symbol: String,
    val operate: (Long, Long) -> Long,
) {
    PLUS("+", { operand1: Long, operand2: Long -> operand1 + operand2 }),
    MINUS("-", { operand1: Long, operand2: Long -> operand1 - operand2 }),
    MULTIPLY("*", { operand1: Long, operand2: Long -> operand1 * operand2 }),
    DIVIDE("/", { operand1: Long, operand2: Long ->
        require(operand2 != 0L) { "0으로 나눌 수 없습니다." }
        operand1 / operand2
    });

    companion object {
        fun of(symbol: String): ArithmeticOperator {
            return values().firstOrNull { it.symbol == symbol }
                ?: throw IllegalArgumentException("올바른 사칙연산 기호가 아닙니다. (사칙연산기호 : + - * /")
        }
    }
}
