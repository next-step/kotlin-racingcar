package calculator.service

import calculator.model.Operation
import java.math.BigDecimal

private const val PROCESSOR_INIT_COUNT = 1

class StringCalculatorProcessor(
    private val input: List<String>
) {
    init {
        require(input.isNotEmpty()) { "비어있는 리스트는 계산할 수 없습니다." }
    }

    fun process(): BigDecimal {
        val initialValue = BigDecimal(input.first())
        val leftList = input.drop(PROCESSOR_INIT_COUNT)

        var buffer = initialValue
        val iterator = leftList.iterator()
        while (iterator.hasNext()) {
            val operation = Operation.of(iterator.next())
            val nextValue = BigDecimal(iterator.next())
            buffer = operation.apply(buffer, nextValue)
        }

        return buffer
    }
}
