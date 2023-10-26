package calculator.enums

import calculator.enums.ErrorMessages.INVALID_OPERATOR_EXCEPTION
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
            return values().find { it.symbol == symbol } ?: throw IllegalArgumentException(INVALID_OPERATOR_EXCEPTION.message)
        }
    }
}
