package calculator.model

import java.math.BigDecimal
import java.util.Objects.isNull

class OperationBlock(
    val accumulator: BigDecimal,
    val calculation: Operation? = null
) {
    fun apply(nextValue: BigDecimal): BigDecimal {
        checkNotNull(calculation)
        return calculation.apply(accumulator, nextValue)
    }

    fun result(): BigDecimal {
        check(isNull(calculation))
        return accumulator
    }

    companion object {
        fun of(value: String): OperationBlock = OperationBlock(BigDecimal(value))

        fun reduce(buffer: OperationBlock, value: String): OperationBlock {
            if (Operation.isSymbol(value)) {
                return OperationBlock(buffer.result(), Operation.of(value))
            }

            return OperationBlock(buffer.apply(BigDecimal(value)))
        }
    }
}
