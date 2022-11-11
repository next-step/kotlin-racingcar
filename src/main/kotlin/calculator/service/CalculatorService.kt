package calculator.service

import calculator.view.ConsoleInput
import calculator.view.ConsoleOutput

class CalculatorService(private val input: ConsoleInput, private val output: ConsoleOutput) {

    fun start() {
        input.readExpression()
    }
}
