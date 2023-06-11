package step2

class Calculator(private val expressionParser: ExpressionParser) {

    fun calculate(expression: String): Int {
        val expression = expressionParser.parse(expression)
        return calculate(expression.operands, expression.operators)
    }

    private fun calculate(operands: List<Int>, operators: List<Operator>): Int {
        return operators.zip(operands.drop(1))
            .fold(operands.first()) { accumulator, (operator, operand) ->
                operator.execute(accumulator, operand)
            }
    }
}
