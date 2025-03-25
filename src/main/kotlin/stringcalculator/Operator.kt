package stringcalculator

enum class Operator(val symbol: String) {
    PLUS("+") {
        override fun apply(
            a: Double,
            b: Double,
        ) = a + b
    },
    MINUS("-") {
        override fun apply(
            a: Double,
            b: Double,
        ) = a - b
    },
    MULTIPLY("*") {
        override fun apply(
            a: Double,
            b: Double,
        ) = a * b
    },
    DIVIDE("/") {
        override fun apply(
            a: Double,
            b: Double,
        ) = if (b == 0.0) {
            throw IllegalArgumentException("Division by zero is not allowed")
        } else {
            a / b
        }
    }, ;

    abstract fun apply(
        a: Double,
        b: Double,
    ): Double

    companion object {
        fun isOperator(symbol: String): Boolean {
            return entries.any { it.symbol == symbol }
        }

        fun fromSymbol(symbol: String): Operator {
            require(isOperator(symbol)) { "Invalid operator: $symbol" }
            return entries.find { it.symbol == symbol }!!
        }
    }
}
