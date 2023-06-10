package step2

enum class Operator(
    private val value: String,
    private val operation: (Double, Double) -> Double
) {

    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    fun operate(num1: Double, num2: Double): Double {
        return operation.invoke(num1, num2)
    }

    companion object {
        fun from(token: String): Operator? {
            return Operator.values().find {
                it.value == token
            }
        }
    }
}
