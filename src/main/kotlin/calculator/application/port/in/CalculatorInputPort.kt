package calculator.application.port.`in`

import calculator.application.parser.ParsingProcessor
import calculator.domain.calculator.Calculator

interface CalculatorInputPort {
    fun input(inputString: String): String
}

class CalculatorInputPortImpl(
    private val parsingProcessor: ParsingProcessor,
    private val calculator: Calculator<Int>
) : CalculatorInputPort {
    override fun input(inputString: String): String {
        val inputOperationCommandList = parsingProcessor.proceed(inputString)
        return calculator.calculate(inputOperationCommandList).toString()
    }
}
