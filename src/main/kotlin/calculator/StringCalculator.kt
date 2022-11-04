package calculator

import java.math.BigDecimal

class StringCalculator {

    @Throws(IllegalArgumentException::class)
    fun calculateString(str: String?): BigDecimal {
        if (str == null) throw IllegalArgumentException("널 값이 들어옴")
        if (str.isBlank()) throw IllegalArgumentException("공백이 들어옴")
        if (!isExpression(str)) throw IllegalArgumentException("이상한 문자가 들어옴")

        val arr = str.split(" ")

        if (!isNumber(arr.first())) throw IllegalArgumentException("올바른 계산식이 아님")
        if (!isNumber(arr.last())) throw IllegalArgumentException("올바른 계산식이 아님")

        var answer = arr.first().toBigDecimal()

        for (i in 1 until arr.size step 2) {
            val operator = arr[i]
            val num = arr[i + 1]

            if (isNumber(operator)) throw IllegalArgumentException("올바른 계산식이 아님")
            if (!isNumber(num)) throw IllegalArgumentException("올바른 계산식이 아님")

            answer = calculate(answer, num.toBigDecimal(), operator)
        }

        return answer
    }

    private fun isExpression(str: String) =
        Regex("^[0-9|+\\-*/]").containsMatchIn(str)

    private fun isNumber(str: String) =
        runCatching { str.toBigDecimal() }.isSuccess

    private fun calculate(a: BigDecimal, b: BigDecimal, operator: String) =
        when (operator) {
            "+" -> Calculator.plus(a, b)
            "-" -> Calculator.minus(a, b)
            "*" -> Calculator.multiply(a, b)
            else -> Calculator.divide(a, b)
        }
}
