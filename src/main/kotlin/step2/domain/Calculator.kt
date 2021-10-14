package step2.domain

import java.util.StringTokenizer

class Calculator {

    companion object {
        private const val DELIMITER = " "
        const val EXPRESSION_NULL_MESSAGE = "연산식이 null 또는 공백입니다."
    }

    fun calculate(expression: String): Int {
        require(!expression.isNullOrBlank()) { EXPRESSION_NULL_MESSAGE }
        val stringTokenizer = StringTokenizer(expression, DELIMITER)
        var x = Integer.valueOf(stringTokenizer.nextToken())
        while (stringTokenizer.hasMoreTokens()) {
            val operator = stringTokenizer.nextToken()
            val y = stringTokenizer.nextToken()
            val operation = Operator.values(operator)
            x = operation.calculate(x, y)
        }
        return x
    }
}
