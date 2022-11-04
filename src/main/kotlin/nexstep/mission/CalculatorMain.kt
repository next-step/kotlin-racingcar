package nexstep.mission

import nexstep.mission.calculator.CalculatorController
import nexstep.mission.calculator.io.ConsoleInput
import nexstep.mission.calculator.io.ConsoleOutput

fun main(args: Array<String>) {
    val calculatorController = CalculatorController(ConsoleInput, ConsoleOutput)
    calculatorController.calculate()
}
