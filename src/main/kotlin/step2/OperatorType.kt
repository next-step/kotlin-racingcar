package step2

import step2.ExceptionType.CAN_NOT_DIVIDED_BY_ZERO
import step2.ExceptionType.NOT_OPERATOR_SYMBOL

enum class OperatorType(val symbol: String, val operatorBlock: (newValue: Operand, oldValue: Operand) -> Operand) {
    MINUS("-", { newValue, oldValue -> newValue.apply { value -= oldValue.value } }),
    PLUS("+", { newValue, oldValue -> newValue.apply { value += oldValue.value } }),
    DIVIDE(
        "/",
        { newValue, oldValue ->
            require(oldValue.value != 0.0) { CAN_NOT_DIVIDED_BY_ZERO }
            newValue.apply { value /= oldValue.value }
        }
    ),
    MULTIPLY("*", { newValue, oldValue -> newValue.apply { value *= oldValue.value } });

    companion object {
        fun getOperator(symbol: String): (Operand, Operand) -> Operand {
            val type = values().find { it.symbol == symbol } ?: throw IllegalArgumentException(NOT_OPERATOR_SYMBOL)
            return type.operatorBlock
        }
    }
}
