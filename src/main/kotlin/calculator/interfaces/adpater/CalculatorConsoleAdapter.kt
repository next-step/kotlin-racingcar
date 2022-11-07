package calculator.interfaces.adpater

import calculator.application.port.`in`.CalculatorInputPort
import calculator.interfaces.input.StepInputConsole
import calculator.interfaces.output.OutputConsole

class CalculatorConsoleAdapter(
    private val calculatorInputPort: CalculatorInputPort
) {
    fun init() {
        val expression = StepInputConsole.input()
        val result = calculatorInputPort.input(expression)
        OutputConsole.output(result)
    }
}
