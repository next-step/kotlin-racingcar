package calculator.service

import calculator.model.OperationBlock
import java.math.BigDecimal

private const val PROCESSOR_INIT_COUNT = 1

class StringCalculatorProcessor(
    val input: List<String>
) {
    init {
        require(input.isNotEmpty())
    }

    fun process(): BigDecimal {
        val initialValue = input.first()
        val leftList = input.drop(PROCESSOR_INIT_COUNT)
        var block = OperationBlock(BigDecimal(initialValue))

        for (value in leftList) {
            block = block.reduce(value)
        }

        return block.result()
    }
}
