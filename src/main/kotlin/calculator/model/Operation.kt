package calculator.model

import java.math.BigDecimal
import java.math.RoundingMode.FLOOR
import kotlin.math.max

enum class Operation(
    val symbol: String,
    val apply: (BigDecimal, BigDecimal) -> BigDecimal
) {
    ADD("+", BigDecimal::plus),
    SUBTRACT("-", BigDecimal::minus),
    MULTIPLY("*", BigDecimal::multiply),
    DIVIDE("/", { d1, d2 -> d1.divide(d2, max(d1.scale(), d2.scale()), FLOOR) });

    companion object {
        fun of(symbol: String) = values().find { it.symbol == symbol }
            ?: throw IllegalArgumentException("유호하지 않은 연산기호입니다.")
    }
}
