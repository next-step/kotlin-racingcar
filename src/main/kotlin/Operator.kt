enum class Operator(private val symbol: String, val operate: (left: Int, right: Int) -> Int) {
    PLUS("+", { left, right -> left + right }),
    MINUS("-", { left, right -> left - right }),
    MULTIPLE("*", { left, right -> left * right }),
    DIVISION("/", { left, right ->
        try {
            left / right
        } catch (e: Exception) {
            throw IllegalArgumentException(ErrorMessage.NO_DIVISION_ZERO)
        }
    });

    companion object {
        fun getOperator(symbol: String): Operator {
            return values().find { it.symbol == symbol }
                ?: throw UnsupportedOperationException("${ErrorMessage.UN_SUPPORT_OPERATION}: $symbol")
        }

        fun hasOperator(input: String): Boolean {
            return values().any { it.symbol == input }
        }
    }
}
