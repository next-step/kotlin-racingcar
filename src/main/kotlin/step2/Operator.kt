package step2

enum class Operator(val value: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    companion object {
        private const val ERROR_OPERATOR: String = "연산자가 올바르지 않습니다."

        fun execute(num1: Double, num2: Double, operator: String?): Double = when (operator) {
            PLUS.value -> num1 + num2
            MINUS.value -> num1 - num2
            MULTIPLY.value -> num1 * num2
            DIVIDE.value -> num1 / num2
            else -> throw IllegalArgumentException(ERROR_OPERATOR)
        }
    }
}
