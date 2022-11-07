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

private fun plus(firstNum: Int, secondNum: Int) = firstNum + secondNum

private fun minus(firstNum: Int, secondNum: Int) = firstNum - secondNum

private fun multiply(firstNum: Int, secondNum: Int) = firstNum * secondNum

private fun divide(firstNum: Int, secondNum: Int) = if (secondNum == 0) {
    throw ArithmeticException("Cannot be divided by zero")
} else {
    (firstNum / secondNum)
}
