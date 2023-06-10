package calculator

enum class Operator(private val s: String, val operation: (Int, Int) -> Int) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    companion object {
        fun of(symbol: String): Operator {
            val operator = values().find { it.s == symbol }
            return CalculatorValidate.operator(operator)
        }
    }
}
