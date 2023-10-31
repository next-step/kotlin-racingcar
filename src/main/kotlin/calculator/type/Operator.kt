package calculator.type

enum class Operator(val symbol: String, val operationFunction: (a: Int, b: Int) -> Int) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b }),

    NONE("", { a, b -> a })
    ;

    companion object {
        fun of(symbol: String): Operator {
            return values().find { it.symbol == symbol } ?: NONE
        }
    }
}
