package calculator.service

import calculator.model.CalculationBlock
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
        CalculationBlock(BigDecimal(10))
        var block = CalculationBlock.of(first)

        for (value in leftList) {
            block = CalculationBlock.reduce(block, value)
        }

        return block.result()
    }
}
