package step2

data class Expression(val input: String?) {

    fun parse(): List<String> {
        if (input.isNullOrBlank()) throw IllegalArgumentException(ERROR_INPUT_NULL_OR_EMPTY)

        val parsedExpression = input.split(DELIMETER)
        isValidExpression(parsedExpression)

        return parsedExpression
    }

    private fun isValidExpression(parsedExpression: List<String>) {
        require(parsedExpression.size % VALID_GROUP_COUNT != INVALID_EXPRESSION_FORMAT) { ERROR_INVALID_EXPRESSION }
    }

    companion object {
        private const val ERROR_INPUT_NULL_OR_EMPTY = "입력값은 null이거나 빈 공백 문자일 수 없습니다."
        private const val ERROR_INVALID_EXPRESSION = "식이 올바르지 않습니다."

        private const val DELIMETER = " "
        private const val VALID_GROUP_COUNT = 2
        private const val INVALID_EXPRESSION_FORMAT = 0
    }
}
