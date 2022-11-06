import java.math.BigDecimal
import java.math.MathContext

enum class Operator(val symbol: String) {
    ADD("+") {
        override fun calculate(i: BigDecimal, j: BigDecimal): BigDecimal =
            i.add(j)
    },
    MINUS("-") {
        override fun calculate(i: BigDecimal, j: BigDecimal): BigDecimal =
            i.subtract(j)
    },
    MULTIPLE("*") {
        override fun calculate(i: BigDecimal, j: BigDecimal): BigDecimal =
            i.multiply(j)
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

        fun getOperators(): List<String> =
            mutableListOf(
                ADD.symbol,
                MINUS.symbol,
                MULTIPLE.symbol,
                DIVIDE.symbol
            )
    }
}
