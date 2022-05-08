package step2

class InOrderCalculator {

    fun calculator(input: String?): Double {
        val expressions = Expression(input).parse()

        return calculate(expressions)
    }

    private fun calculate(expressions: List<String>): Double {
        var result: Double = parseValidDouble(expressions.firstOrNull())
        var operator: Operator = Operator.of(expressions[FIRST_OPERATOR])

        (2 until expressions.size).forEach { index ->
            if (isOperator(index)) {
                operator = Operator.of(expressions[index])
            } else {
                result = operator.execute(result, parseValidDouble(expressions[index]))
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
        private const val FIRST_OPERATOR = 1
    }
}
