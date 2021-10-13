package step2

import java.util.StringTokenizer

class Calculator {

    fun calculate(expression: String): Int {
        validateNull(expression)
        val stringTokenizer = StringTokenizer(expression, " ")
        var x = Integer.valueOf(stringTokenizer.nextToken())
        while (stringTokenizer.hasMoreTokens()) {
            val operator = stringTokenizer.nextToken()
            val y = stringTokenizer.nextToken()
            val operation = Operator.values(operator)
            x = operation.calculate(x, y)
        }
        return x
    }

    private fun validateNull(expression: String) {
        if (expression.isNullOrBlank()) throw IllegalArgumentException()
    }
}
