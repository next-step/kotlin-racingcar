package calculator.data

class TextReader() {
    companion object {
        private const val BLANK_NOT_ALLOWED = "빈값이 들어갈 수 없습니다"
        private const val NOT_OPERATOR = "연산자가 입력되지 않았습니다"
        private const val DELIMITER = " "
    }

    fun parseText(text: String?): List<String> {
        if (text.isNullOrBlank()) {
            throw IllegalArgumentException(BLANK_NOT_ALLOWED)
        }
        val parsedText = text.split(DELIMITER)
        for (i in parsedText.indices) {
            checkMathOperators(parsedText, i)
        }
        return parsedText
    }

    private fun checkMathOperators(parsedText: List<String>, i: Int) {
        if (isOperator(i)) {
            checkMathOperator(parsedText[i])
        }
    }

    private fun isOperator(i: Int) = i % 2 == 1

    private fun checkMathOperator(operator: String) {
        val operators = listOf("+", "-", "*", "/")

        if (!operators.contains(operator)) {
            throw IllegalArgumentException(NOT_OPERATOR)
        }
    }
}
