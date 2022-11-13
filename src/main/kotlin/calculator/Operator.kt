package calculator

enum class Operator(val symbol: String, val calculate: (Int, Int) -> Int) {
    ADDITION("+", { first, second -> first + second }),
    SUBTRACTION("-", { first, second -> first - second }),
    MULTIPLICATION("*", { first, second -> first * second }),
    DIVISION("/", { first, second -> first / second }),
    ;

    companion object {
        fun valueOfSymbol(symbol: String): Operator = values().find { it.symbol == symbol }
            ?: throw IllegalArgumentException("It is not four basic arithmetic operations")
    }
}
