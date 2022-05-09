package step2

enum class Operator(private val value: String, private val calculate: (Double, Double) -> Double) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    fun execute(num1: Double, num2: Double): Double = calculate.invoke(num1, num2)

    companion object {
        private const val ERROR_OPERATOR: String = "연산자가 올바르지 않습니다."

        fun of(value: String): Operator =
            values().find { value == it.value } ?: throw IllegalArgumentException(ERROR_OPERATOR)
    }
}
