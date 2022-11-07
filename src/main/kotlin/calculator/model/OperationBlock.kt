package calculator.model

import java.math.BigDecimal
import java.util.Objects.isNull

class OperationBlock(
    val accumulator: BigDecimal,
    val operation: Operation? = null
) {
    fun result(): BigDecimal {
        check(isNull(operation)) { "아직 처리되지 않은 연산이 존재합니다." }
        return accumulator
    }

    fun apply(nextValue: BigDecimal): BigDecimal {
        checkNotNull(operation) { "블럭에 연산이 존재하지 않아 처리할 수 없습니다." }
        return operation.apply(accumulator, nextValue)
    }

    fun reduce(value: String): OperationBlock {
        if (Operation.isSymbol(value)) {
            return OperationBlock(result(), Operation.of(value))
        }

        return OperationBlock(apply(BigDecimal(value)))
    }
}
