package step2

enum class MathOperator(val symbol: String, val operation: (Int, Int) -> Int) {
    PLUS(symbol = "+", operation = { x, y -> x + y }),
    MINUS(symbol = "-", operation = { x, y -> x - y }),
    MULTIPLY(symbol = "*", operation = { x, y -> x * y }),
    DIVIDE(symbol = "/", operation = { x, y -> x / y });

    companion object {
        fun from(operator: String): MathOperator? {
            return values().find { it.symbol == operator }
        }
    }

    fun calculate(x: Int, y: Int): Int {
        return operation(x, y)
    }
}
