package calculator

class Calculator {
    fun calculate(expression: String): Int {
        val exprArr = expression.split(" ")

        var result = exprArr[0].toIntOrNull() ?: throw IllegalArgumentException()

        for (id: Int in 1 until exprArr.size step 2) {
            val operator = Operator.valueOf(sign = exprArr[id][0]) ?: throw IllegalArgumentException()
            val operand = exprArr[id + 1].toIntOrNull() ?: throw IllegalArgumentException()
            result = operator.operate(result, operand)
        }

        return result
    }
}
