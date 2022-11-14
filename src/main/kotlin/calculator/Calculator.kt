package calculator

class Calculator {
    companion object {
        const val EXPRESSION_DELIMITER = " "
    }

    fun calculate(expression: String): Int {
        val exprArr = expression.split(EXPRESSION_DELIMITER)

        var result = exprArr[0].toIntOrNull() ?: throw IllegalArgumentException()

        for (id: Int in 1 until exprArr.size step 2) {
            val opr = Operator.valueOf(sign = exprArr[id][0]) ?: throw IllegalArgumentException()
            val operand = exprArr[id + 1].toIntOrNull() ?: throw IllegalArgumentException()
            result = opr.operate(result, operand)
        }

        return result
    }
}
