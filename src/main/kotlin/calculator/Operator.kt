package calculator

import java.math.BigDecimal
import java.util.function.BiFunction

enum class Operator(
    private val type: String,
    private val expression: BiFunction<Long, Long, BigDecimal>
) {
    PLUS("+", { a: Long, b: Long -> BigDecimal.valueOf(a).plus(BigDecimal.valueOf(b)) }),
    MINUS("+", { a: Long, b: Long -> BigDecimal.valueOf(a).minus(BigDecimal.valueOf(b)) }),
    MULTI("+", { a: Long, b: Long -> BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b)) }),
    DIVIDE("+", { a: Long, b: Long -> BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b)) });

    fun calculate(a: Long, b: Long): BigDecimal {
        return expression.apply(a, b)
    }
}
