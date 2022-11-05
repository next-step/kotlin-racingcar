package calculator.model

import java.math.BigDecimal
import java.util.Objects.isNull

class OperationBlock(
    val accumulator: BigDecimal,
    val calculation: Operation? = null
) {
    fun result(): BigDecimal {
        check(isNull(calculation))
        return accumulator
    }

    fun apply(nextValue: BigDecimal): BigDecimal {
        checkNotNull(calculation)
        return calculation.apply(accumulator, nextValue)
    }

    fun reduce(value: String): OperationBlock {
        if (Operation.isSymbol(value)) {
            return OperationBlock(result(), Operation.of(value))
        }

        return OperationBlock(apply(BigDecimal(value)))
    }
}
