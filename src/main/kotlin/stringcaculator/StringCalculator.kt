package stringcaculator

class StringCalculator {
    fun calculate(expression: String): Int {
        checkExpressionIsNullOrBlank(expression)
        var result = 0
        var operator = Operator.PLUS

        for ((i, op) in expression.split(" ").withIndex()) {
            if (i % 2 == 0) {
                result = operandCalculate(result, op, operator)
                continue
            }
            operator = Operator.of(op)
        }
        return result
    }

    private fun operandCalculate(result: Int, operand: String, operator: Operator): Int {
        val num = operand.toIntOrNull() ?: throw IllegalArgumentException("Not a valid operand")
        return operator.calculate(result, num)
    }

    private fun checkExpressionIsNullOrBlank(expression: String) {
        require(expression.isNotBlank()) { "Expression can't be blank" }
    }
}
