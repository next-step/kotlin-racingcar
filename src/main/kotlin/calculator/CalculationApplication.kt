package calculator

import calculator.service.CalculatorService
import calculator.view.ConsoleInput
import calculator.view.ConsoleOutput

fun main() {
    val input = ConsoleInput()
    val output = ConsoleOutput()

    CalculatorService(input, output).start()
}
