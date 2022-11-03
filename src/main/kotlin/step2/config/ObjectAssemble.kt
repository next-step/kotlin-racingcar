package step2.config

import step2.application.parser.implement.SequentialParsingProcessor
import step2.application.port.`in`.CalculatorInputPortImpl
import step2.domain.calculator.impl.StandardCalculator
import step2.interfaces.adpater.CalculatorConsoleAdapter

object ObjectAssemble {
    fun calculatorView() = CalculatorConsoleAdapter(calculatorInputPort())
    private fun parsingProcessor() = SequentialParsingProcessor()
    private fun calculator() = StandardCalculator()
    private fun calculatorInputPort() = CalculatorInputPortImpl(parsingProcessor(), calculator())
}
