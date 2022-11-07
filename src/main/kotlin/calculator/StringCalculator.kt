package calculator

import calculator.Operator.Companion.calculate
import java.math.BigDecimal

class StringCalculator {

    fun calculateString(str: String?): BigDecimal {
        if (str.isNullOrBlank()) throw IllegalArgumentException("널 혹은 공백이 들어옴")

        val arr = str.split(" ")
        if (!isExpression(arr)) throw IllegalArgumentException("올바른 계산식이 아님")
        var answer = arr.first().toBigDecimal()

        for (i in 1 until arr.size step 2) {
            val operator = arr[i]
            val num = arr[i + 1]

            if (!isOperator(operator)) throw IllegalArgumentException("올바른 계산식이 아님")
            if (!isNumber(num)) throw IllegalArgumentException("올바른 계산식이 아님")
            answer = calculate(answer, num.toBigDecimal(), operator)
        }

        return answer
    }

    private fun isExpression(arr: List<String>) =
        arr.size % 2 == 1

    private fun isOperator(str: String) =
        Regex("[+\\-*/]").containsMatchIn(str)

    private fun isNumber(str: String) =
        Regex("[0-9]").containsMatchIn(str)
}
