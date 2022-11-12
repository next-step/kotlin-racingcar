package calculator

import calculator.controller.CalculatorController
import calculator.view.ConsoleInput
import calculator.view.ConsoleOutput

fun main() {
    val input = ConsoleInput()
    val output = ConsoleOutput()

    CalculatorController(input, output).calculate()
}
