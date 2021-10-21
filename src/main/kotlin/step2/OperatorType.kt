package step2

import step2.ExceptionType.CAN_NOT_DIVIDED_BY_ZERO
import step2.ExceptionType.NOT_OPERATOR_SYMBOL

enum class OperatorType(val symbol: String, val operatorBlock: (oldValue: Operand, newValue: Operand) -> Operand) {
    MINUS("-", { oldValue, newValue -> oldValue.apply { value -= newValue.value } }),
    PLUS("+", { oldValue, newValue -> oldValue.apply { value += newValue.value } }),
    DIVIDE(
        "/",
        { oldValue, newValue ->
            require(newValue.value != 0.0) { CAN_NOT_DIVIDED_BY_ZERO }
            oldValue.apply { value /= newValue.value }
        }
    ),
    MULTIPLY("*", { oldValue, newValue -> oldValue.apply { value *= newValue.value } });

    companion object {
        fun findOperator(symbol: String): (Operand, Operand) -> Operand {
            val type = values().find { it.symbol == symbol } ?: throw IllegalArgumentException(NOT_OPERATOR_SYMBOL)
            return type.operatorBlock
        }
    }
}
