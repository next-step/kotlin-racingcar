package calculator

enum class ArithmeticOperator(
    private val symbol: String,
) {
    PLUS("+") { override fun operate(operand1: Long, operand2: Long): Long = operand1 + operand2 },
    MINUS("-") { override fun operate(operand1: Long, operand2: Long): Long = operand1 - operand2 },
    MULTIPLY("*") { override fun operate(operand1: Long, operand2: Long): Long = operand1 * operand2 },
    DIVIDE("/") {
        override fun operate(operand1: Long, operand2: Long): Long {
            require(operand2 != 0L) { "0으로 나눌 수 없습니다." }
            return operand1 / operand2
        }
    };

    abstract fun operate(operand1: Long, operand2: Long): Long

    companion object {
        fun of(symbol: String): ArithmeticOperator {
            return values().firstOrNull { it.symbol == symbol }
                ?: throw IllegalArgumentException("올바른 사칙연산 기호가 아닙니다. (사칙연산기호 : + - * /")
        }
    }
}
