import java.util.function.BinaryOperator

enum class Operator(val symbol: String, val method: BinaryOperator<Int>) {
    PLUS("+", BinaryOperator { t: Int, u: Int -> t + u }),
    MINUS("-", BinaryOperator { t: Int, u: Int -> t - u }),
    MULTIPLY("*", BinaryOperator { t: Int, u: Int -> t * u }),
    DIVIDE("/", BinaryOperator { t: Int, u: Int -> t / u });

    companion object {
        fun findSymbolOperator(symbol: String): BinaryOperator<Int> {
            return values().find { it.symbol == symbol }!!.method
        }

        fun symbolList(): List<String> {
            return values().map { it.symbol }
        }
    }
}
