package calculator

class Calculator(
    private val parser: Parser
) {
    private var result: Int = 0

    fun calculate(input: Input): Int {
        val elements = parser.parse(input)
        result = elements[0].toInt()

        for (i in 1 until elements.size step 2) {
            val operator = elements[i]
            val operand = elements[i + 1].toInt()

            val operatorType = Operator.findByStringOperator(operator)
            result = operatorType.execute(result, operand)
        }

        return result
    }
}
