package step2

class InOrderCalculator {

    fun calculate(input: String?): Double {
        val expressions = Expression(input).parse()

        var result: Double = parseValidDouble(expressions.firstOrNull())
        var operator: Operator = Operator.of(expressions[FIRST_OPERATOR])

        (START_VALID_EXPRESSION_INDEX until expressions.size).forEach { index ->
            if (isOperator(index)) {
                operator = Operator.of(expressions[index])
            } else {
                result = operator.execute(result, parseValidDouble(expressions[index]))
            }
        }
        return result
    }

    private fun isOperator(index: Int): Boolean = index % VALID_GROUP_COUNT != IS_NOT_OPERATOR_POSITION

    private fun parseValidDouble(value: String?): Double {
        return value?.toDouble() ?: throw IllegalArgumentException(ERROR_INPUT_NUMBER)
    }

    companion object {
        private const val ERROR_INPUT_NUMBER = "잘못된 숫자를 입력하였습니다."
        private const val FIRST_OPERATOR = 1
        private const val VALID_GROUP_COUNT = 2
        private const val IS_NOT_OPERATOR_POSITION = 0

        private const val START_VALID_EXPRESSION_INDEX = 2
    }
}
