package step2.enums

enum class StringOperator(
    val symbol: String,
    val operation: (Int, Int) -> Int
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    companion object {
        fun from(symbol: String): StringOperator {
            return values().firstOrNull { it.symbol == symbol } ?: throw IllegalArgumentException()
        }
    }
}
