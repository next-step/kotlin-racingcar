package calculator

enum class Operator(
    private val symbol: String,
    val operate: (Int, Int) -> Int,
) {
    ADD("+", { operand1, operand2 -> operand1 + operand2 }),
    SUBTRACT("-", { operand1, operand2 -> operand1 - operand2 }),
    MULTIPLY("*", { operand1, operand2 -> operand1 * operand2 }),
    DIVIDE("/", { operand1, operand2 ->
        require(operand2 != 0) { "0으로 나눌 수 없습니다." }
        operand1 / operand2
    }),
    ;

    companion object {
        fun of(symbol: String): Operator {
            return values().find { it.symbol == symbol }
                ?: throw IllegalArgumentException("사칙연산 기호가 올바르지 않습니다. : $symbol")
        }
    }
}
