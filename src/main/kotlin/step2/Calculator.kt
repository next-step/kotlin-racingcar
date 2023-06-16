package step2

class Calculator(private val expressionParser: ExpressionParser) {

    fun calculate(expression: String): Int {
        // destructuring 적용
        // data class인 경우, 이렇게 사용할 수도 있음
        val (operands, operators) = expressionParser.parse(expression)
        return calculate(operands, operators)
    }

    private fun calculate(operands: List<Int>, operators: List<Operator>): Int {
        return operators.zip(operands.drop(1))
            .fold(operands.first()) { accumulator, (operator, operand) ->
                operator.execute(accumulator, operand)
            }
    }
}
