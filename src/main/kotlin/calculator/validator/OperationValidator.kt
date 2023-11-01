package calculator.validator

object OperationValidator {
    private val regexValidCharacter = """^[0-9+\-*/\s]+$""".toRegex() // 숫자나 +, -, *, /, 공백만 허용
    private val regexEndWithNumber = """[0-9]$""".toRegex() // 마지막 문자가 숫자인지 확인
    private val regexDuplicateOperator = """[+\-*/]{2,}""".toRegex() // 연산자가 연속으로 나오는 경우 확인

    fun isCorrectExpression(expression: String): Boolean {
        if (expression.isEmpty()) return false
        if (!expression.first().isDigit()) return false

        return madeWithNumberAndOperator(expression) &&
            endWithNumber(expression) &&
            !hasDuplicateOperator(expression)
    }

    private fun madeWithNumberAndOperator(expression: String) = expression.matches(regexValidCharacter)

    private fun hasDuplicateOperator(expression: String) = expression.contains(regexDuplicateOperator)

    private fun endWithNumber(expression: String) = expression.last().toString().matches(regexEndWithNumber)

    fun hasValidSize(expressionList: List<String>): Boolean = expressionList.size >= 3
}
