package calculator

enum class Operator(private val value: String, val operate: (Long, Long) -> Long) {
    PLUS("+", { operand1, operand2 -> operand1 + operand2 }),
    MINUS("-", { operand1, operand2 -> operand1 - operand2 }),
    MUL("*", { operand1, operand2 -> operand1 * operand2 }),
    DIV("/", { operand1, operand2 ->
        if (operand2 == 0L) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
        operand1 / operand2
    });

    operator fun invoke(operand1: Long, operand2: Long): Long = operate(operand1, operand2)

    companion object {
        fun getOperator(value: String): Operator =
            values().find { operator -> operator.value == value }
                ?: throw IllegalArgumentException("해당하는 연산자가 없습니다")
    }
}
