package calculator

enum class Operator(val symbol: String, val method: (Int, Int) -> Int) {
    PLUS("+", { t: Int, u: Int -> t + u }),
    MINUS("-", { t: Int, u: Int -> t - u }),
    MULTIPLY("*", { t: Int, u: Int -> t * u }),
    DIVIDE("/", { t: Int, u: Int -> t / u });

    companion object {
        fun findSymbolOperator(symbol: String): (Int, Int) -> Int {
            return values().find { it.symbol == symbol }!!.method
        }

        fun symbolList(): List<String> {
            return values().map { it.symbol }
        }
    }
}
