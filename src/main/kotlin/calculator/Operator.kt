package calculator

enum class Operator(
    private val symbol: String,
    private val operate: (left: Int, right: Int) -> Int
) {
    PLUS("+", { left, right -> left + right }),
    MINUS("-", { left, right -> left - right }),
    MULTIPLY("*", { left, right -> left * right }),
    SUBTRACT(
        "/",
        { left, right ->
            if (right == 0) {
                throw IllegalArgumentException()
            }
            left / right
        }
    );

    fun apply(left: Int, right: Int): Int {
        return operate(left, right)
    }

    companion object {
        fun find(symbol: String): Operator {
            return values().single { it.symbol == symbol }
        }
    }
}
