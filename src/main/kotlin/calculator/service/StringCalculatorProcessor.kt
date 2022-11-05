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
        var block = OperationBlock(BigDecimal(first))

        for (value in leftList) {
            block = block.reduce(value)
        }

        return block.result()
    }
}
