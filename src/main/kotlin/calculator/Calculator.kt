package calculator

import game.racingcar.util.requireOrThrow

class Calculator {

    fun calculate(expression: String): Int {

        require(expression.isNotBlank()) { MESSAGE_MUST_NOT_EMPTY }

        val tokens = expression.split(DELIMITER)
        tokens
            .filterIndexed { index, _ -> index % 2 == 0 }
            .requireOrThrow("$MESSAGE_WRONG_EXPRESSION ($expression)") { it.toIntOrNull() != null }

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
