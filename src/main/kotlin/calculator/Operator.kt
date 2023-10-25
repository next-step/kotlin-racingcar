package calculator

enum class Operator(val symbol: String, val operation: (Int, Int) -> Int) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    TIMES("*", { x, y -> x * y }),
    DIVISION("/", { x, y -> x / y });
}
