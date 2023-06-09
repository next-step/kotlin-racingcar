package calculator

enum class Operator(private val s: String, val operation: (Int, Int) -> Int) {
    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    // abstract fun operation(x: Int, y: Int): Int

    companion object {
        fun of(symbol: String): Operator {
            val operator = values().find { it.s == symbol }
            require(operator != null) {
                "사칙연산 기호가 아닌 경우"
            }
            return operator
        }
    }
}
