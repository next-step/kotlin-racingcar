package step2.interfaces.adpater

import step2.application.port.`in`.CalculatorInputPort

class CalculatorAdapter(
    private val calculatorInputPort: CalculatorInputPort
) {
    fun calculate(input: String): String = calculatorInputPort.input(input).toString()
}
