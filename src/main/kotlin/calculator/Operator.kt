package calculator

enum class Operator(val symbol: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    companion object {
        fun symbolOf(symbol: String) = values().find { it.symbol == symbol }
            ?: throw IllegalArgumentException("It's not an arithmetic operation symbol")
    }
}

fun operate(accumulation: Int, operator: Operator, operand: Int) =
    when (operator) {
        Operator.PLUS -> plus(accumulation, operand)
        Operator.MINUS -> minus(accumulation, operand)
        Operator.MULTIPLY -> multiply(accumulation, operand)
        Operator.DIVIDE -> divide(accumulation, operand)
    }

private fun plus(num1: Int, num2: Int) = num1 + num2

private fun minus(num1: Int, num2: Int) = num1 - num2

private fun multiply(num1: Int, num2: Int) = num1 * num2

private fun divide(num1: Int, num2: Int) = num1 / num2
