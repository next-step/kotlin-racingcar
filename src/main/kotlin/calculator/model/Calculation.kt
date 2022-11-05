package calculator.model

import java.math.BigDecimal
import java.math.RoundingMode.HALF_EVEN
import kotlin.math.max

enum class Calculation(
    val symbol: String,
    val calculate: (BigDecimal, BigDecimal) -> BigDecimal
) {
    ADD("*", BigDecimal::plus),
    SUBTRACT("-", BigDecimal::minus),
    MULTIPLY("*", BigDecimal::multiply),
    DIVIDE("/", { d1, d2 -> d1.divide(d2, max(d1.scale(), d2.scale()), HALF_EVEN) });

    companion object {
        fun of(symbol: String) {
            values().find { it.symbol == symbol }
                ?: throw IllegalArgumentException()
        }
    }
}
