package stringcalculator

enum class Operator(val symbol: String, val operate: (Number, Number) -> Number) {
    PLUS("+", { source, target -> source + target }),
    MINUS("-", { source, target -> source - target }),
    TIMES("*", { source, target -> source * target }),
    DIVIDE("/", { source, target -> source / target });


    companion object {
        private val store = values().associateBy(Operator::symbol)

        fun findBySymbol(symbol: String): Operator {
            return store[symbol] ?: throw IllegalArgumentException("Not Found Symbol :$symbol")
        }
    }
}