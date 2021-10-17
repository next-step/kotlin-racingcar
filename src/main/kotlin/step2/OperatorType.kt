package step2

import step2.ExceptionType.Companion.CAN_NOT_DIVIDED_BY_ZERO
import step2.ExceptionType.Companion.NOT_OPERATOR_SYMBOL

enum class OperatorType(val symbol: String, val operator: Operator) {
    MINUS("-", Operator { a, b -> a - b }),
    PLUS("+", Operator { a, b -> a + b }),
    DIVIDE(
        "/",
        Operator { a, b ->
            require(b != 0.0) { CAN_NOT_DIVIDED_BY_ZERO }
            a / b
        }
    ),
    MULTIPLY("*", Operator { a, b -> a * b });

    companion object {
        fun getOperator(symbol: String): Operator {
            val type = values().find { it.symbol == symbol } ?: throw IllegalArgumentException(NOT_OPERATOR_SYMBOL)
            return type.operator
        }
    }
}
