package calculator.application.service

enum class Operator(
    val operator: String,
    val calculate: (Operand, Operand) -> Operand,
) {
    ADD("+", { x, y -> x + y }),
    SUB("-", { x, y -> x - y }),
    MUL("*", { x, y -> x * y }),
    DIV("/", { x, y ->
        if (y == Operand.ZERO) {
            throw ArithmeticException("나누기 연산의 오른쪽 피연산자가 0입니다.")
        }
        x / y
    });

    companion object {
        fun findByString(value: String): Operator = values().find { it.operator == value }
            ?: throw IllegalArgumentException("지원하지 않는 연산자입니다. value: $value")
    }
}
