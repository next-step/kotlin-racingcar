package calculator

enum class ArithmeticOperator(
    val symbol: String,
    val operate: (Int, Int) -> Int,
) {
    PLUS("+", Int::plus),
    MINUS("-", Int::minus),
    MULTIPLY("*", Int::times),
    DIVIDE("/", { a, b ->
        kotlin.runCatching { a.div(b) }
            .getOrElse { throw IllegalArgumentException("Division by 0 is undefined.") }
    }),
    ;

    companion object {
        fun from(symbol: String) =
            entries.find { it.symbol == symbol }
                ?: throw IllegalArgumentException("Invalid operator: $symbol. Use only +, -, *, /.")
    }
}
