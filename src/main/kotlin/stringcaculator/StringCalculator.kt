package stringcaculator

class StringCalculator {
    fun calculate(expression: String): Int {

        checkExpressionIsNullOrBlank(expression)
        var result = 0
        var operator = Operator.PLUS

        for (it in expression.split(" ")) {
            if (isNumber(it)) {
                result = operator.calculate(result, it.toInt())
                continue
            }
            operator = Operator.of(it)
        }
        return result
    }

    private fun isNumber(operand: String): Boolean {
        return operand.toCharArray().all { it.isDigit() }
    }

    private fun checkExpressionIsNullOrBlank(expression: String) {
        require(expression.isNotBlank()) { "Expression can't be blank" }
    }
}
