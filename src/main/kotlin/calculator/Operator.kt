package calculator

enum class Operator(val symbol: String) {
    ADD(symbol = "+") {
        override fun calculate(
            left: Double,
            right: Double,
        ): Double {
            return left + right
        }
    },
    SUBTRACT(symbol = "-") {
        override fun calculate(
            left: Double,
            right: Double,
        ): Double {
            return left - right
        }
    },
    MULTIPLY(symbol = "*") {
        override fun calculate(
            left: Double,
            right: Double,
        ): Double {
            return left * right
        }
    },
    DIVIDE(symbol = "/") {
        override fun calculate(
            left: Double,
            right: Double,
        ): Double {
            return left / right
        }
    }, ;

    companion object {
        private val SYMBOL_TO_OPERATOR = entries.associateBy { it.symbol }

        fun fromSymbolOrThrow(symbol: String): Operator =
            SYMBOL_TO_OPERATOR[symbol] ?: throw IllegalArgumentException("Invalid operator: $symbol")
    }

    abstract fun calculate(
        left: Double,
        right: Double,
    ): Double
}
