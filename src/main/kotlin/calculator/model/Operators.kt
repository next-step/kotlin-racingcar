package calculator.model

import calculator.exception.ErrorMessages
import calculator.exception.ErrorMessages.NOT_SUPPORTED_OPERATOR
import java.lang.IllegalArgumentException

enum class Operators(val symbol: String, val operation: (Int, Int) -> Int) {
    PLUS("+", { first, second -> first + second }),
    MINUS("-", { first, second -> first - second }),
    MULTIPLY("*", { first, second -> first * second }),
    DIVIDE("/", { first, second -> first / second });

    fun operate(first: Int, second: Int): Int {
        return operation(first, second)
    }

    companion object {
        private val OPERATOR_REGEX = "^[0-9+\\-/* ]+\$".toRegex()

        fun validateOperator(value: String): Operators {
            require(OPERATOR_REGEX.matches(value)) {
                ErrorMessages.INVALID_OPERATOR_EXCEPTION.message
            }
            return findValue(value)
        }

        private fun findValue(symbol: String): Operators {
            return values().find { it.symbol == symbol } ?: throw IllegalArgumentException(NOT_SUPPORTED_OPERATOR.message)
        }
    }
}
