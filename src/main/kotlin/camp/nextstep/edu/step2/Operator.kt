package camp.nextstep.edu.step2

enum class Operator constructor(val symbol: String, val operator: (Double, Double) -> Double) {
    PLUS("+", { num1, num2 -> num1 + num2 }),
    MINUS("-", { num1, num2 -> num1 - num2 }),
    TIMES("*", { num1, num2 -> num1 * num2 }),
    DIVIDE("/", { num1, num2 -> num1 / num2 })
    ;

    operator fun invoke(left: Double, right: Double) = operator(left, right)

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
