package calculator

object Calculator {
    fun calculate(input: String): Int {
        val expressionParser = ExpressionParser.of(input)
        val operands = expressionParser.getOperands()
        val operators = expressionParser.getOperators()
        return calculate(operands, operators)
    }

    private fun calculate(operands: List<Int>, operators: List<Operator>): Int {
        val remainingOperators = operators.toMutableList()
        val result = operands.reduce { acc, next ->
            val operator = remainingOperators.removeFirst()
            operator.calculate(acc, next)
        }

        if (remainingOperators.isNotEmpty()) {
            throw IllegalStateException("올바르지 않은 연산식 입니다.")
        }
        return result
    }
}
