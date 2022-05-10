package calculator

import java.math.BigDecimal
import java.util.function.BiFunction

enum class Operator(
    val type: String,
    private val expression: BiFunction<Int, Int, BigDecimal>
) {
    PLUS("+", { a: Int, b: Int -> BigDecimal(a).plus(BigDecimal(b)) }),
    MINUS("-", { a: Int, b: Int -> BigDecimal(a).minus(BigDecimal(b)) }),
    MULTI("*", { a: Int, b: Int -> BigDecimal(a).multiply(BigDecimal(b)) }),
    DIVIDE("/", { a: Int, b: Int -> BigDecimal(a).divide(BigDecimal(b)) });

    fun calculate(a: Int, b: Int): BigDecimal {
        return expression.apply(a, b)
    }
}
