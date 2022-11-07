import java.math.BigDecimal
import java.math.MathContext

enum class Operator(val symbol: String) {
    ADD("+") {
        override fun calculate(i: BigDecimal, j: BigDecimal): BigDecimal =
            i + j
    },
    MINUS("-") {
        override fun calculate(i: BigDecimal, j: BigDecimal): BigDecimal =
            i - j
    },
    MULTIPLE("*") {
        override fun calculate(i: BigDecimal, j: BigDecimal): BigDecimal =
            i * j
    },
    DIVIDE("/") {
        override fun calculate(i: BigDecimal, j: BigDecimal): BigDecimal =
            i.divide(j, MathContext.DECIMAL64)
    };

    abstract fun calculate(i: BigDecimal, j: BigDecimal): BigDecimal

    companion object {
        fun symbolOf(operation: String) =
            values().firstOrNull { it.symbol == operation }
                ?: throw IllegalArgumentException()

        fun isContains(symbol: String): Boolean =
            Operator.values().map { it.symbol }.contains(symbol)
    }
}
