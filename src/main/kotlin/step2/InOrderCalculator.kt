package step2

class InOrderCalculator {
    private val ERROR_INPUT_NULL_OR_EMPTY = "입력값은 null이거나 빈 공백 문자일 수 없습니다."
    private val ERROR_INPUT_NUMBER = "잘못된 숫자를 입력하였습니다."
    private val ERROR_EXPRESSION = "식이 올바르지 않습니다."

    private val DELIMETER = " "

    fun calculate(expression: String?): Double {
        if (expression.isNullOrBlank()) throw IllegalArgumentException(ERROR_INPUT_NULL_OR_EMPTY)

        val expressions = expression.split(DELIMETER).toMutableList()
        if (expressions.size % 2 == 0) throw IllegalArgumentException(ERROR_EXPRESSION)

        var result: Double = expressions[0].toValidDouble()
        var operator: String? = null

        (1 until expressions.size).forEach { index ->
            if (index % 2 != 0) {
                //isOperator
                operator = expressions[index]
            } else {
                result = Operator.execute(result, expressions[index].toValidDouble(), operator)
            }
        }
        return result
    }

    private fun String?.toValidDouble(): Double {
        if (this.isNullOrBlank()) throw IllegalArgumentException(ERROR_INPUT_NUMBER)

        try {
            return this.toDouble()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_INPUT_NUMBER)
        }
    }
}
