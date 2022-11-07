package calculator.assemble

import calculator.application.parser.implement.SequentialParsingProcessor
import calculator.application.port.`in`.CalculatorInputPortImpl
import calculator.domain.calculator.impl.StandardCalculator
import calculator.interfaces.adpater.CalculatorConsoleAdapter
import calculator.interfaces.input.impl.SingleInputConsole

object ObjectAssemble {
    fun calculatorView() = CalculatorConsoleAdapter(calculatorInputPort(), inputConsole())
    private fun calculatorInputPort() = CalculatorInputPortImpl(parsingProcessor(), calculator())
    private fun inputConsole() = SingleInputConsole
    private fun parsingProcessor() = SequentialParsingProcessor()
    private fun calculator() = StandardCalculator()
}
