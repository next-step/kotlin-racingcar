package stringcalculator

import util.KnownException

enum class Operator(val value: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    ;

    companion object {
        fun of(value: String): Operator {
            return values().find { it.value == value }
                ?: throw IllegalArgumentException(KnownException.INVALID_OPERATOR.message)
        }
    }
}