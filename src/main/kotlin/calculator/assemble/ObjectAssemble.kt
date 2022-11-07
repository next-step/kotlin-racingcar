package calculator.assemble

import calculator.application.parser.implement.SequentialParsingProcessor
import calculator.application.port.`in`.CalculatorInputPortImpl
import calculator.domain.calculator.impl.StandardCalculator
import calculator.interfaces.adpater.CalculatorConsoleAdapter
import calculator.interfaces.input.impl.SingleInputConsole

object ObjectAssemble {
    fun calculatorView() = CalculatorConsoleAdapter(inputConsole = inputConsole(), calculatorInputPort = calculatorInputPort())
    private fun inputConsole() = SingleInputConsole
    private fun calculatorInputPort() = CalculatorInputPortImpl(parsingProcessor = parsingProcessor(), calculator = calculator())
    private fun parsingProcessor() = SequentialParsingProcessor()
    private fun calculator() = StandardCalculator()
}
