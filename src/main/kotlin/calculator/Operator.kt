package calculator

enum class Operator(
    val symbol: String,
) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    ;

    companion object {
        fun fromSymbol(symbol: String): Operator {
            return Operator.values()
                .find { it.symbol == symbol }
                ?: throw NoSuchElementException("There is no Operator with symbol $symbol.")
        }

        fun getFourBasicOperators(): Set<Operator> {
            return setOf(PLUS, MINUS, MULTIPLY, DIVIDE)
        }
    }
}
