package study.calculator

class Expression(private val operatorToken: String, private val numberToken: String) {
    val operator: Operator = when (operatorToken) {
        "+" -> Operator.ADD
        "-" -> Operator.SUBTRACT
        "*" -> Operator.MULTIPLY
        "/" -> Operator.DIVIDE
        else -> throw IllegalArgumentException("invalid operator")
    }

    val number: Int = numberToken.toIntOrNull()
        ?: throw IllegalArgumentException("invalid number")

    fun evaluate(operand: Int): Int {
        return when (operator) {
            Operator.ADD -> operand + number
            Operator.SUBTRACT -> operand - number
            Operator.MULTIPLY -> operand * number
            Operator.DIVIDE -> operand / number
        }
    }

    enum class Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}
