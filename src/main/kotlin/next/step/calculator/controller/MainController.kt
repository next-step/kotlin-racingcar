package next.step.calculator.controller

import next.step.calculator.service.Calculator
import next.step.calculator.service.InputDevice
import next.step.calculator.service.OutputDevice

fun main() {
    while (true) {
        if (InputDevice.readActionCommand().isQuit()) {
            break
        }
        calculate()
    }
}

private fun calculate() {
    try {
        val calculationCmd = InputDevice.readCalculationCommand()
        val result = Calculator.calculate(calculationCmd)
        OutputDevice.showResult(calculationCmd, result)
    } catch (e: Exception) {
        OutputDevice.showError(e.message)
        calculate()
    }
}
