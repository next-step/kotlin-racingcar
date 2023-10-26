package calculator

enum class Operator(val symbol: String, val calcFunc: (Int, Int) -> Int) {
    PLUS("+", { operand1, operand2 -> operand1 + operand2}),
    MINUS("-", { operand1, operand2 -> operand1 - operand2}),
    MULTIPLY("*", { operand1, operand2 -> operand1 * operand2}),
    DIVIDE("/", { operand1, operand2 -> operand1 / operand2});

    companion object {
        fun fromSymbol(symbol: String): Operator {
            return values().find { it.symbol == symbol } ?: throw IllegalArgumentException("Unsupported operator symbol: $symbol")
        }
    }
}