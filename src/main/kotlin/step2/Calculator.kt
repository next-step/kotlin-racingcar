package step2

class Calculator(private val expressionParser: ExpressionParser) {

    fun calculate(expression: String): Int {
        expressionParser.parse(expression)
        val operands = expressionParser.getOperandsInOrder()
        val operators = expressionParser.getOperatorInOrder()

        return calculate(operands, operators)
    }

    private fun calculate(operands: List<Int>, operators: List<Operator>): Int {
        var acc = operands.first()

        for (i in operators.indices) {
            val operator = operators[i]
            val operand = operands[i + 1]
            acc = operator.execute(acc, operand)
        }
        return acc
    }
}
