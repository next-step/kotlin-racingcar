package calculator

enum class Operator(private val value: String, val operate: (Long, Long) -> Long) {
    PLUS("+", { op1, op2 -> op1 + op2 }),
    MINUS("-", { op1, op2 -> op1 - op2 }),
    MUL("*", { op1, op2 -> op1 * op2 }),
    DIV("/", { op1, op2 -> op1 / op2 });

    operator fun invoke(op1: Long, op2: Long): Long = operate(op1, op2)

    companion object {
        fun getOperator(value: String): Operator =
            values().find { operator -> operator.value == value }
                ?: throw IllegalArgumentException("해당하는 연산자가 없습니다")
    }
}
