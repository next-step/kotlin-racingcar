package calculator

class Calculator(
    private val parser: Parser
) {
    fun calculate(expression: Expression): Int {
        val elements = parser.parse(expression)
        var result = elements.first().toInt()

        for (i in 1 until elements.size step 2) {
            val operator = elements[i]
            val operand = elements[i + 1].toInt()

            val operatorType = Operator.findByStringOperator(operator)
            result = operatorType.execute(result, operand)
        }

        return result
    }
}
