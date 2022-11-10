package step2

import java.lang.IllegalArgumentException

enum class TokenType(
    val isOperator: () -> Boolean,
    val isOperand: () -> Boolean,
) {
    OPERATOR(isOperator = { true }, isOperand = { false }),
    OPERAND(isOperator = { false }, isOperand = { true }),
    ;

    companion object {
        fun getByValue(value: String): TokenType {
            val isNumber = { value: String -> value.toIntOrNull() != null }
            val isOperatorLabel = { value: String -> Operator.existsByLabel(label = value) }

            if (isNumber(value)) {
                return OPERAND
            }

            if (isOperatorLabel(value)) {
                return OPERATOR
            }

            throw IllegalArgumentException("토큰 유형은 연산자 또는 피연산자만 가능합니다.")
        }
    }
}
