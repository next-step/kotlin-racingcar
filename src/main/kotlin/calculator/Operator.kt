package calculator

enum class Operator {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE;

    companion object {
        fun of(operator: String): Operator {
            return when (operator) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> MULTIPLY
                "/" -> DIVIDE
                else -> throw IllegalArgumentException("지원하지 않는 연산자입니다")
            }
        }

        fun calculate(operator: Operator, operand1: Int, operand2: Int): Int {
            return when (operator) {
                PLUS -> operand1 + operand2
                MINUS -> operand1 - operand2
                MULTIPLY -> operand1 * operand2
                DIVIDE -> operand1 / operand2
            }
        }
    }

    fun calculate(operand1: Int, operand2: Int): Int {
        return calculate(this, operand1, operand2)
    }
}
