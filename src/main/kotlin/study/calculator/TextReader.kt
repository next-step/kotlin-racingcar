package study.calculator

class TextReader(text: String?) {
    companion object {
        private const val BLANK_NOT_ALLOWED = "빈값이 들어갈 수 없습니다"
        private const val NOT_OPERATOR = "연산자가 입력되지 않았습니다"
        private const val DELIMITER = " "
    }

    var result: List<String>

    init {
        if (text == null || text.isBlank()) {
            throw IllegalArgumentException(BLANK_NOT_ALLOWED)
        }
        result = text.split(DELIMITER)

        for (i in result.indices) {
            checkMathOperators(i)
        }
    }

    private fun checkMathOperators(i: Int) {
        if (isOperator(i)) {
            checkMathOperator(result[i])
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
