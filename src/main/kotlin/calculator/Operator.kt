package calculator

enum class Operator(
    private val symbol: String,
    private val expression: (operand1: Operand, operand2: Operand) -> Operand
) {
    PLUS(symbol = "+", expression = { operand1: Operand, operand2: Operand -> operand1 + operand2 }),
    MINUS(symbol = "-", expression = { operand1: Operand, operand2: Operand -> operand1 - operand2 }),
    MULTIPLE(symbol = "*", expression = { operand1: Operand, operand2: Operand -> operand1 * operand2 }),
    DIVISION(symbol = "/", expression = { operand1: Operand, operand2: Operand -> operand1 / operand2 }), ;

    fun calculate(operand1: Operand, operand2: Operand): Operand {
        return this.expression(operand1, operand2)
    }

    companion object {
        fun of(value: String): Operator {
            return values().firstOrNull { it.symbol == value }
                ?: throw IllegalArgumentException("지원하지 않는 연산자 입니다. operator: $value")
        }
    }
}
