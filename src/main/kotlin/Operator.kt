enum class Operator(private val symbol: String, private val operate: (left: Int, right: Int) -> Int) {
    PLUS("+", { left, right -> left + right }),
    MINUS("-", { left, right -> left - right }),
    MULTIPLE("*", { left, right -> left * right }),
    DIVISION("/", { left, right ->
        try {
            left / right
        } catch (e: Exception) {
            throw IllegalArgumentException(Error.NO_DIVISION_ZERO)
        }
    });

    fun execute(left: Int, right: Int): Int {
        return operate.invoke(left, right)
    }

    companion object {
        fun getOperator(symbol: String): Operator {
            return when (symbol) {
                PLUS.symbol -> PLUS
                MINUS.symbol -> MINUS
                MULTIPLE.symbol -> MULTIPLE
                else -> DIVISION
            }
        }
    }
}
