enum class Operator(private val symbol: String, val apply: (Int, Int) -> Int) {
    plus("+", { a, b -> a + b }),
    minus("-", { a, b -> a - b }),
    multiply("*", { a, b -> a * b }),
    divide("/", { a, b ->
        if (b == 0) throw IllegalArgumentException("Cannot divide by zero")
        else a / b
    });

    companion object {
        fun from(symbol: String): Operator {
            return entries.find { it.symbol == symbol }
                ?: throw IllegalArgumentException("Unsupported operator: '$symbol'")
        }

        fun getValidSymbols(): List<Char> {
            return Operator.entries.map { it.symbol.single() }
        }
    }
}