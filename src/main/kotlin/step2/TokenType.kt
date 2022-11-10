package step2

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
            if (isNumber(value)) {
                return OPERAND
            }
            return OPERATOR
        }
    }
}
