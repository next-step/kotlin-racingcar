package calculator

enum class Operator(val symbol: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    fun apply(number1: Int, number2: Int) =
        when (this) {
            PLUS -> number1 + number2
            MINUS -> number1 - number2
            MULTIPLY -> number1 * number2
            DIVIDE -> number1 / number2
        }
}

fun String.findOperator(): Operator {
    return Operator.values().firstOrNull() { it.symbol == this }
        ?: throw IllegalArgumentException("사칙 연산 기호가 아닙니다")
}
