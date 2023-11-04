package calculator

enum class Operator(
    val symbol: String,
    val execute: (Int, Int) -> Int,
) {
    PLUS("+", { operand1, operand2 -> operand1 + operand2 }),
    MINUS("-", { operand1, operand2 -> operand1 - operand2 }),
    MULTIPLY("*", { operand1, operand2 -> operand1 * operand2 }),
    DIVIDE("/", { operand1, operand2 -> operand1 / operand2 });

    fun calculate(operand1: Int, operand2: Int): Int {
        return this.execute(operand1, operand2)
    }

    companion object {
        fun of(operator: String): Operator {
            return values().find { it.symbol == operator }
                ?: throw IllegalArgumentException("지원하지 않는 연산자입니다")
        }
    }
}
