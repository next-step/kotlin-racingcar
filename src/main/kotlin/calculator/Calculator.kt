package calculator

class Calculator {

    fun calculate(expression: String): Int {

        require(expression.isNotBlank()) { MESSAGE_MUST_NOT_EMPTY }

        val tokens = expression.split(DELIMITER)
        val numberOfOperator = tokens.filterIndexed { index, s -> index % 2 == 1 && s.toIntOrNull() == null }.size
        require(numberOfOperator == tokens.size / 2) { "$MESSAGE_WRONG_EXPRESSION ($expression)" }

        val result = tokens.drop(1).windowed(2, 2, true).fold(tokens[0].toInt()) { acc, strings ->
            val operator = Operator.of(strings[0])
            operator.operate(acc, strings[1].toInt())
        }

        return result
    }

    companion object {
        const val DELIMITER = " "
        const val MESSAGE_MUST_NOT_EMPTY = "빈 값이 올 수 없습니다."
        const val MESSAGE_WRONG_EXPRESSION = "잘못된 식입니다."
    }
}
