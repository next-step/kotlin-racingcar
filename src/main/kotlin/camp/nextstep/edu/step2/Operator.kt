package camp.nextstep.edu.step2

enum class Operator constructor(val symbol: String) {
    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIVIDE("/")
    ;

    companion object {
        private val symbolMap: Map<String, Operator> = mapOf(
            PLUS.symbol to PLUS,
            MINUS.symbol to MINUS,
            TIMES.symbol to TIMES,
            DIVIDE.symbol to DIVIDE,
        )

        fun fromSymbol(symbol: String): Operator = symbolMap[symbol] ?: throw IllegalArgumentException("$symbol is invalid operator (use only [+,-,/,*]).")
    }
}
