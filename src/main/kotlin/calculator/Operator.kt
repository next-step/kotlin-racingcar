package calculator

enum class Operator(
    private val symbol: String,
    private val operation: (Double, Double) -> Double
) {

    ADD("+", { a, b -> a + b }),
    SUBTRACT("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    companion object {
        fun operation(operator: String): (Double, Double) -> Double {
            return values()
                .find { it.symbol == operator }
                ?.operation
                ?: throw IllegalArgumentException()
        }
    }
}
