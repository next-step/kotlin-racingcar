package step2

import step2.ExceptionType.CAN_NOT_DIVIDED_BY_ZERO
import step2.ExceptionType.NOT_OPERATOR_SYMBOL

enum class OperatorType(val symbol: String, val operatorBlock: (a: Operand, b: Operand) -> Operand) {
    MINUS("-", { a, b -> a.apply { value -= b.value } }),
    PLUS("+", { a, b -> a.apply { value += b.value } }),
    DIVIDE(
        "/",
        { a, b ->
            require(b.value != 0.0) { CAN_NOT_DIVIDED_BY_ZERO }
            a.apply { value /= b.value }
        }
    ),
    MULTIPLY("*", { a, b -> a.apply { value *= b.value } });

    companion object {
        fun getOperator(symbol: String): (Operand, Operand) -> Operand {
            val type = values().find { it.symbol == symbol } ?: throw IllegalArgumentException(NOT_OPERATOR_SYMBOL)
            return type.operatorBlock
        }
    }
}
