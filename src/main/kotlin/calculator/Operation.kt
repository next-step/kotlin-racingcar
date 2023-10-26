package calculator

enum class Operation(val operation: String, val operate: (a: Int, b: Int) -> Int) {
    PLUS("+", { a, b -> a.plus(b) }),
    MINUS("-", { a, b -> a.minus(b) }),
    MULTIPLY("*", { a, b -> a.times(b) }),
    DIVIDE("/", { a, b -> a.div(b) }),
}
