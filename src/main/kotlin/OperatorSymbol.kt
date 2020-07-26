enum class OperatorSymbol(val symbol: String, val method: Operator) {
    PLUS("+", Operator.PLUS),
    MINUS("-", Operator.MINUS),
    MULTIPLY("*", Operator.MULTIPLY),
    DIVIDE("/", Operator.DIVIDE);

    companion object {
        fun findSymbolOperator(symbol: String): Operator {
            return values().find { it.symbol == symbol }!!.method
        }

        fun symbolList(): List<String> {
            return values().map { it.symbol }
        }
    }
}
