package calculator.controller

import calculator.domain.Calculator
import calculator.view.ConsoleInput
import calculator.view.ConsoleOutput

class CalculatorController(private val input: ConsoleInput, private val output: ConsoleOutput) {

    fun calculate() {
        val expression = input.readExpression()
        val result = Calculator.calculate(expression.toMutableList())
        output.print(result)
    }
}
