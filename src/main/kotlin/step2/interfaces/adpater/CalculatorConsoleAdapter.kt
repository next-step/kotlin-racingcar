package step2.interfaces.adpater

import step2.application.port.`in`.CalculatorInputPort
import step2.interfaces.input.InputConsole
import step2.interfaces.output.OutputConsole

class CalculatorConsoleAdapter(
    private val calculatorInputPort: CalculatorInputPort
) {
    fun calculate() {
        val expression = InputConsole.input()
        val result = calculatorInputPort.input(expression).toString()
        OutputConsole.output(result)
    }
}
