package calculator

enum class ArithmeticOperator(
    private val symbol: String,
    val operate: (ArithmeticOperand, ArithmeticOperand) -> ArithmeticOperand,
) {
    PLUS("+", { operand1, operand2 -> operand1 + operand2 }),
    MINUS("-", { operand1, operand2 -> operand1 - operand2 }),
    MULTIPLY("*", { operand1, operand2 -> operand1 * operand2 }),
    DIVIDE("/", { operand1, operand2 ->
        require(operand2 != ArithmeticOperand(0L)) { "0으로 나눌 수 없습니다." }
        operand1 / operand2
    }),
    ;

    companion object {

        private val symbols = values().map(ArithmeticOperator::symbol).toSet()

        fun of(symbol: String): ArithmeticOperator {
            return values().firstOrNull { it.symbol == symbol }
                ?: throw IllegalArgumentException("사용 가능한 사칙연산 기호는 " + symbols + "입니다.")
        }
    }
}
