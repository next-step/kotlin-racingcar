package step2

class InOrderCalculator {

    fun calculator(input: String?): Double {
        val expressions = Expression(input).parse()

        return calculate(expressions)
    }

    private fun calculate(expressions: List<String>): Double {
        var result: Double = parseValidDouble(expressions[0])
        var operator: String? = null

        (1 until expressions.size).forEach { index ->
            if (isOperator(index)) {
                operator = expressions[index]
            } else {
                result = Operator.execute(result, parseValidDouble(expressions[index]), operator)
            }
        }
        return result
    }

    private fun isOperator(index: Int): Boolean = index % 2 != 0

    private fun parseValidDouble(value: String?): Double {
        return value?.toDouble() ?: throw IllegalArgumentException(ERROR_INPUT_NUMBER)
    }

    companion object {
        private const val ERROR_INPUT_NUMBER = "잘못된 숫자를 입력하였습니다."
    }
}
