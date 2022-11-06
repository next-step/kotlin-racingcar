package calculator.application.port.`in`

import calculator.application.parser.ParsingProcessor
import calculator.domain.calculator.Calculator

interface CalculatorInputPort<T> {
    fun input(inputString: String): T
}

class CalculatorInputPortImpl(
    private val parsingProcessor: ParsingProcessor,
    private val calculator: Calculator<Int>
) : CalculatorInputPort<Int> {
    override fun input(inputString: String): Int {
        val inputOperationCommandList = parsingProcessor.proceed(inputString)
        return calculator.calculate(inputOperationCommandList)
    }
}
