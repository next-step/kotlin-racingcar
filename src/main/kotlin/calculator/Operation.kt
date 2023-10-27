package calculator

enum class Operation(val symbol: String) {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    companion object {
        fun fromSymbol(symbol: String): Operation {
            return values().find { it.symbol == symbol }
                ?: throw IllegalArgumentException("Not Valid Form")
        }
    }
}
