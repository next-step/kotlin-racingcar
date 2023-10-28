package stringcalculator

import util.CalculatorException

enum class Operator(val value: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    ;

    companion object {
        fun of(value: String): Operator {
            return values().find { it.value == value }
                ?: throw IllegalArgumentException(CalculatorException.INVALID_OPERATOR.message)
        }
    }
}
