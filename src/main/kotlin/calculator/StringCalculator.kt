package calculator

import java.math.BigDecimal
import java.math.RoundingMode.HALF_EVEN
import kotlin.math.max

class StringCalculator {
    companion object {
        fun add(addend: BigDecimal, augend: BigDecimal): BigDecimal = addend.plus(augend)

        fun subtract(minuend: BigDecimal, subtrahend: BigDecimal): BigDecimal = minuend.minus(subtrahend)

        fun multiply(multiplier: BigDecimal, multiplicand: BigDecimal): BigDecimal = multiplier.times(multiplicand)

        fun divide(dividend: BigDecimal, divisor: BigDecimal): BigDecimal =
            dividend.divide(divisor, max(dividend.scale(), divisor.scale()), HALF_EVEN)

        fun calculate(string2: String?) {
            TODO("Not yet implemented")
        }
    }
}
