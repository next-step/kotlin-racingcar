package calculator.model

import java.math.BigDecimal
import java.util.Objects.isNull

class CalculationBlock(
    val accumulator: BigDecimal,
    val calculation: Calculation? = null
) {
    fun apply(nextValue: BigDecimal): BigDecimal {
        checkNotNull(calculation)
        return calculation.calculate(accumulator, nextValue)
    }

    fun result(): BigDecimal {
        check(isNull(calculation))
        return accumulator
    }

    companion object {
        fun of(value: String): CalculationBlock {
            return CalculationBlock(BigDecimal(value))
        }

        fun reduce(buffer: CalculationBlock, value: String): CalculationBlock {
            if (Calculation.isSymbol(value)) {
                return CalculationBlock(buffer.result(), Calculation.of(value))
            }

            return CalculationBlock(buffer.apply(BigDecimal(value)))
        }
    }
}
