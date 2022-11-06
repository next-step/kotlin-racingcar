package calculator

enum class Operator(val symbol: String, val operate: (Int, Int) -> (Int)) {
    PLUS("+", { acc, operand -> plus(acc, operand) }),
    MINUS("-", { acc, operand -> minus(acc, operand) }),
    MULTIPLY("*", { acc, operand -> multiply(acc, operand) }),
    DIVIDE("/", { acc, operand -> divide(acc, operand) });

    companion object {
        fun symbolOf(symbol: String) = values().find { it.symbol == symbol }
            ?: throw IllegalArgumentException("It's not an arithmetic operation symbol")
    }
}

private fun plus(num1: Int, num2: Int) = num1 + num2

private fun minus(num1: Int, num2: Int) = num1 - num2

private fun multiply(num1: Int, num2: Int) = num1 * num2

private fun divide(num1: Int, num2: Int) = num1 / num2
