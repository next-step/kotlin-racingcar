package string.calculator.enum

enum class Operator {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE;

    companion object {
        private const val NOT_SUPPORTED_OPERATOR = "지원하지 않는 연산자입니다."

        fun of(operator: String): Operator {
            return when (operator) {
                "+" -> PLUS
                "-" -> MINUS
                "*" -> MULTIPLY
                "/" -> DIVIDE
                else -> throw IllegalArgumentException(NOT_SUPPORTED_OPERATOR)
            }
        }
    }
}
