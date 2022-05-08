package calculator

class Calculator {

    fun calculate(expression: String): Int {

        if (expression.isBlank()) {
            throw IllegalArgumentException("빈 값이 올 수 없습니다.")
        }

        val tokens = expression.split(DELIMITER)
        if (tokens.size % 2 == 0) {
            throw IllegalArgumentException("잘못된 식입니다. ($expression)")
        }

        val result = tokens.drop(1)
            .windowed(2, 2, true)
            .fold(tokens[0].toInt()) { acc, strings ->
                try {
                    val operator = Operator.of(strings[0])
                    operator.operate(acc, strings[1].toInt())
                } catch (e: java.lang.NumberFormatException) {
                    throw IllegalArgumentException("잘못된 식입니다. ($expression)")
                }
            }

        return result
    }

    companion object {
        const val DELIMITER = " "
    }
}
