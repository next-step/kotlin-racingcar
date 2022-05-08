package step2

class InOrderCalculator {

    fun calculate(expression: String?): Double {
        val expressions = Expression(expression).parse()

        var result: Double = expressions[0].toValidDouble()
        var operator: String? = null

        (1 until expressions.size).forEach { index ->
            if (isOperator(index)) {
                operator = expressions[index]
            } else {
                result = Operator.execute(result, expressions[index].toValidDouble(), operator)
            }
        }
        return result
    }

    private fun isOperator(index: Int): Boolean = index % 2 != 0

    private fun String?.toValidDouble(): Double {
        if (this.isNullOrBlank()) throw IllegalArgumentException(ERROR_INPUT_NUMBER)

        try {
            return this.toDouble()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_INPUT_NUMBER)
        }
    }

    companion object {
        private const val ERROR_INPUT_NUMBER = "잘못된 숫자를 입력하였습니다."
    }
}
