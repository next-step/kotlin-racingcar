package calculator.validator

object OperationValidator {
    private val REGEX_VALID_CHARACTER = """^[0-9+\-*/\s]+$""".toRegex() // 숫자나 +, -, *, /, 공백만 허용
    private val REGEX_END_WITH_NUMBER = """[0-9]$""".toRegex() // 마지막 문자가 숫자인지 확인
    private val REGEX_DUPLICATE_OPERATOR = """[+\-*/]{2,}""".toRegex() // 연산자가 연속으로 나오는 경우 확인

    fun isCorrectExpression(expression: String): Boolean {
        if (expression.isEmpty()) return false
        if (!expression.first().isDigit()) return false

        return madeWithNumberAndOperator(expression) &&
            endWithNumber(expression) &&
            !hasDuplicateOperator(expression)
    }

    private fun madeWithNumberAndOperator(expression: String) = expression.matches(REGEX_VALID_CHARACTER)

    private fun hasDuplicateOperator(expression: String) = expression.contains(REGEX_DUPLICATE_OPERATOR)

    private fun endWithNumber(expression: String) = expression.last().toString().matches(REGEX_END_WITH_NUMBER)

    fun hasValidSize(expressionList: List<String>): Boolean = expressionList.size >= 3
}
