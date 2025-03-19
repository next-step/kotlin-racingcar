package calculator

class Calculator {
    fun execute(
        symbol: String,
        operand1: Int,
        operand2: Int,
    ): Int {
        return Operator.entries.find { it.symbol == symbol }?.action?.invoke(operand1, operand2)
            ?: throw IllegalArgumentException("Invalid operator: $symbol")
    }
}
