import ExceptionCase.Companion.CASE_DIVISION_NUMBER_ZERO
import ExceptionCase.Companion.CASE_INCORRECT_SYMBOL

/**
 * 사측연산 기호 정의하는 class
* */
enum class CalculateSymbol(val symbol: String) : Calculator {
    PLUS("+") {
        override fun calculator(first: Int, second: Int): Int {
            return first + second
        }
    },
    MINUS("-") {
        override fun calculator(first: Int, second: Int): Int {
            return first - second
        }
    },
    MULTIPLY("*") {
        override fun calculator(first: Int, second: Int): Int {
            return first * second
        }
    },
    DiVISION("/") {
        override fun calculator(first: Int, second: Int): Int {
            if (first == 0 || second == 0) throw IllegalArgumentException(CASE_DIVISION_NUMBER_ZERO)
            return first / second
        }
    };

    companion object {
        fun convertSymbol(string: String): CalculateSymbol {
            return when (string) {
                PLUS.symbol -> PLUS
                MINUS.symbol -> MINUS
                MULTIPLY.symbol -> MULTIPLY
                DiVISION.symbol -> DiVISION
                else -> throw IllegalArgumentException(CASE_INCORRECT_SYMBOL)
            }
        }
    }
}
