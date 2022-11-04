package nexstep.mission

import nexstep.mission.calculator.CalculatorConfig

fun main(args: Array<String>) {
    val calculatorController = CalculatorConfig.calculatorController()
    calculatorController.calculate()
}
