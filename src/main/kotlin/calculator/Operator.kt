package calculator

enum class Operator(
    val operator: String
) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    companion object {
        fun isInEnum(str: String) = values().any { it.operator == str }

        fun fromValue(operator: String): Operator? {
            return values().firstOrNull { it.operator == operator }
        }

        fun operate(operator: Operator, a: Double, b: Double) = when (operator) {
            PLUS -> a + b
            MINUS -> a - b
            DIVIDE -> a / b
            MULTIPLY -> a * b
        }
    }
}
