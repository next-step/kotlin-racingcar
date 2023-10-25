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
