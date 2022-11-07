package calculator.interfaces.adpater

import calculator.application.port.`in`.CalculatorInputPort
import calculator.interfaces.input.InputConsole
import calculator.interfaces.output.OutputConsole

class CalculatorConsoleAdapter(
    private val calculatorInputPort: CalculatorInputPort,
    private val inputConsole: InputConsole
) {
    fun init() {
        val expression = inputConsole.input()
        val result = calculatorInputPort.input(expression)
        OutputConsole.output(result)
    }
}
