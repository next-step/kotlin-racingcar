package calculator.enums

import calculator.enums.ErrorMessages.NOT_SUPPORTED_OPERATOR
import java.lang.IllegalArgumentException
import java.util.function.BiFunction

enum class Operators(val symbol: String, private val operation: BiFunction<Int, Int, Int>) {
    PLUS("+", BiFunction { first: Int, second: Int -> first + second }),
    MINUS("-", BiFunction { first: Int, second: Int -> first - second }),
    MULTIPLY("*", BiFunction { first: Int, second: Int -> first * second }),
    DIVIDE("/", BiFunction { first: Int, second: Int -> first / second });

    fun operate(first: Int, second: Int): Int {
        return operation.apply(first, second)
    }

    companion object {
        fun findValue(symbol: String): Operators {
            return values().find { it.symbol == symbol } ?: throw IllegalArgumentException(NOT_SUPPORTED_OPERATOR.message)
        }
    }
}
