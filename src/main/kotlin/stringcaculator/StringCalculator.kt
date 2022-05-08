package stringcaculator

class StringCalculator {
    private var currentOperator: Operator = Operator.PLUS
    fun calculate(expression: String?): Int {
        checkExpressionIsNullOrBlank(expression)

        var result = 0
        expression!!.split(" ").forEach {
            result = operandCalculate(it, result)
        }
        return result
    }

    private fun operandCalculate(expression: String, result: Int): Int {
        if (!isNumber(expression)) {
            setOperator(expression)
            return result
        }
        return currentOperator.calculate(result, expression.toInt())
    }

    private fun setOperator(operator: String) {
        val validOperator = Operator.values().find { it.operator == operator }
        require(validOperator != null)
        currentOperator = validOperator
    }

    private fun isNumber(operand: String): Boolean {
        return operand.toCharArray().all { it.isDigit() }
    }

    private fun checkExpressionIsNullOrBlank(expression: String?) {
        require(!expression.isNullOrBlank())
    }
}
