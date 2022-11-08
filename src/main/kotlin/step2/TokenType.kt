package step2

enum class TokenType {
    OPERATOR, OPERAND;

    companion object {
        fun getByValue(value: String): TokenType {
            val isNumber = { value: String -> value.toIntOrNull() != null }
            return if (isNumber(value)) OPERAND else OPERATOR
        }
    }
}
