package calculator

class Operator(private val symbol: String) {

    fun operation(): ((Double, Double) -> Double) = when (symbol) {
        "+" -> { a, b -> a + b }
        "-" -> { a, b -> a - b }
        "*" -> { a, b -> a * b }
        "/" -> { a, b -> a / b }
        else -> throw IllegalArgumentException()
    }
}
