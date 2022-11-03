package step2.application.port.`in`

import step2.application.parser.ParsingProcessor
import step2.domain.calculator.Calculator

interface CalculatorInputPort {
    fun input(inputString: String): Int
}

class CalculatorInputPortImpl(
    private val parsingProcessor: ParsingProcessor,
    private val calculator: Calculator
) : CalculatorInputPort {
    override fun input(inputString: String): Int {
        val inputOperationCommandList = parsingProcessor.proceed(inputString)
        return calculator.calculate(inputOperationCommandList)
    }
}
