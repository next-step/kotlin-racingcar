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
            if (operator.equals("+")) {
                x = Math.addExact(x, Integer.valueOf(y))
            }
            if (operator.equals("-")) {
                x = Math.subtractExact(x, Integer.valueOf(y))
            }
            if (operator.equals("*")) {
                x = Math.multiplyExact(x, Integer.valueOf(y))
            }
        }
        return x
    }

    private fun validateNull(expression: String) {
        if (expression.isNullOrBlank()) throw IllegalArgumentException()
    }
}
