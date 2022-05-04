package calculator.domain

enum class Operator(
    val symbol: String,
    val operation: (left: Operand, right: Operand) -> Operand
) {

    PLUS("+", { left, right -> left + right }),
    MINUS("-", { left, right -> left - right }),
    TIMES("*", { left, right -> left * right }),
    DIVIDE("/", { left, right -> left / right });

    companion object {
        fun of(symbol: String): Operator = values().find { it.symbol == symbol } ?: throw IllegalArgumentException("사칙 연산이 아닌 연산자는 지원하지 않습니다")
    }
}
