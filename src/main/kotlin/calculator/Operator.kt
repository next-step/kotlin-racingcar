package calculator

enum class Operator(val symbol: String, val operation: (Int, Int) -> Int) {
    PLUS("+", { x, y -> x + y }),
}
