package calculator

enum class Operator(val symbol: String, val calcFunc: (Int, Int) -> Int) {
    PLUS("+", { operand1, operand2 -> operand1 + operand2 }),
    MINUS("-", { operand1, operand2 -> operand1 - operand2 }),
    MULTIPLY("*", { operand1, operand2 -> operand1 * operand2 }),
    DIVIDE("/", { operand1, operand2 -> if (operand2 != 0) operand1 / operand2 else 0 });

    companion object {
        fun fromSymbol(symbol: String): Operator {
            return values().find { it.symbol == symbol } ?: throw IllegalArgumentException("지원하지 않는 연산자가 들어왔다.")
        }
    }
}