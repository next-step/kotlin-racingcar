package step2

data class Expression(val input: String?) {

    fun parse(): List<String> {
        requireNotNull(input) { ERROR_INPUT_NULL_OR_EMPTY }

        val parsedExpression = input.split(DELIMETER).toMutableList()
        isValidExpression(parsedExpression)

        return parsedExpression
    }

    private fun isValidExpression(parsedExpression: MutableList<String>) {
        require(parsedExpression.size % STANDARD_VALID_EXPRESSION != INVALID_EXPRESSION_FORMAT) { ERROR_EXPRESSION }
    }

    companion object {
        private const val ERROR_INPUT_NULL_OR_EMPTY = "입력값은 null이거나 빈 공백 문자일 수 없습니다."
        private const val ERROR_EXPRESSION = "식이 올바르지 않습니다."

        private const val DELIMETER = " "
        private const val STANDARD_VALID_EXPRESSION = 2
        private const val INVALID_EXPRESSION_FORMAT = 0
    }
}
