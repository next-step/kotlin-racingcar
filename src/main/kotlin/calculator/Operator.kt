package calculator

enum class Operator(
    private val symbol: String,
    private val operation: (Double, Double) -> Double
) {

    ADD("+", { a, b -> a + b }),
    SUBTRACT("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    fun operate(a: Double, b: Double) = operation(a, b)

    companion object {
        fun of(symbol: String): Operator {
            return values()
                .find { it.symbol == symbol }
                ?: throw IllegalArgumentException()
        }
    }
}
