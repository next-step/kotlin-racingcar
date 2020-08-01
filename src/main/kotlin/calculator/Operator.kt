package calculator

enum class Operator(private val symbol: String, val operation: (Double, Double) -> Double) {
    PLUS(symbol = "+", operation = { a, b -> a + b }),
    MINUS(symbol = "-", operation = { a, b -> a - b }),
    MULTIPLE(symbol = "*", operation = { a, b -> a * b }),
    DIVIDE(symbol = "/", operation = { a, b -> a / b });
}
