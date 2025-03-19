package calculator

class Calculator(expressionParser: ExpressionParser) {
    private val operators = expressionParser.getOperators()
    private val operands = expressionParser.getOperands()

    fun execute(): Int {
        var result = operands.first()

        operators.forEachIndexed { index, symbol ->
            val operand2 = operands[index + NEXT_OPERAND_INDEX]
            result = calculate(symbol, result, operand2)
        }
        return result
    }

    private fun calculate(
        symbol: String,
        operand1: Int,
        operand2: Int,
    ): Int {
        return Operator.entries.find { it.symbol == symbol }?.action?.invoke(operand1, operand2)
            ?: throw IllegalArgumentException("Invalid operator: $symbol")
    }

    companion object {
        private const val NEXT_OPERAND_INDEX = 1
    }
}
