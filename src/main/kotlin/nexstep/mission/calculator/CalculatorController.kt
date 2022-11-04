package nexstep.mission.calculator

import nexstep.mission.calculator.io.Input
import nexstep.mission.calculator.io.Output

class CalculatorController(
    private val input: Input,
    private val output: Output
) {

    fun calculate() {
        val expression = input.input()
        val result = Calculator.calculate(expression = expression)
        output.output(result)
    }
}
