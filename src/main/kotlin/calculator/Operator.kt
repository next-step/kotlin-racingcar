package calculator

enum class Operator(val symbol: String, val operate: (Double, Double) -> Double) {
    ADD("+", {left, right -> left + right}),
    SUBTRACT("-", {left, right -> left - right}),
    MULTIPLY("*", {left, right -> left * right}),
    DIVIDE("/", {left, right -> left / right});

    companion object {
        fun fromSymbol(symbol: String): Operator {
            return values().find { it.symbol == symbol }
                ?: throw IllegalArgumentException("Please Check the Input")
        }
    }
}
