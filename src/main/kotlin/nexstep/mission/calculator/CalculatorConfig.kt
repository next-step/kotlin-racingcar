package nexstep.mission.calculator

import nexstep.mission.calculator.io.ConsoleInput
import nexstep.mission.calculator.io.ConsoleOutput

object CalculatorConfig {

    fun calculatorController() = CalculatorController(ConsoleInput, ConsoleOutput)
}
