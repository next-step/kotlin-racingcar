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
    runCatching {
        val calculationCmd = InputDevice.readCalculationCommand()
        val result = Calculator.calculate(calculationCmd)
        Calculation(calculationCmd, result)
    }.onSuccess {
        OutputDevice.showResult(it.cmd, it.result)
    }.onFailure { e ->
        OutputDevice.showError(e.message)
        calculate()
    }
}

data class Calculation(val cmd: String, val result: Int)
