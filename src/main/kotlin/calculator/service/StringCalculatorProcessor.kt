package calculator.service

import calculator.model.OperationBlock
import java.math.BigDecimal

private const val ONE = 1

class StringCalculatorProcessor(
    val input: List<String>
) {
    init {
        require(input.isNotEmpty())
    }

    fun process(): BigDecimal {
        val first = input.first()
        val leftList = input.drop(ONE)
        var block = OperationBlock.of(first)

        for (value in leftList) {
            block = OperationBlock.reduce(block, value)
        }

        return block.result()
    }
}
