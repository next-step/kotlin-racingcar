package calculator.assemble

import calculator.application.parser.implement.SequentialParsingProcessor
import calculator.application.port.`in`.CalculatorInputPortImpl
import calculator.domain.calculator.impl.StandardCalculator
import calculator.interfaces.adpater.CalculatorConsoleAdapter

object ObjectAssemble {
    fun calculatorView() = CalculatorConsoleAdapter(calculatorInputPort())
    private fun calculatorInputPort() = CalculatorInputPortImpl(parsingProcessor(), calculator())
    private fun parsingProcessor() = SequentialParsingProcessor()
    private fun calculator() = StandardCalculator()
}
