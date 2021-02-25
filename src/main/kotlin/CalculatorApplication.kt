package calculator

import calculator.calculator.ui.CalculatorController
import calculator.view.console.ConsoleInput
import calculator.view.console.ConsoleOutput

val consoleOutput: ConsoleOutput = ConsoleOutput()
val consoleInput: ConsoleInput = ConsoleInput()

fun main() {
    consoleOutput.printExpressionInputMessage()
    val result = CalculatorController().run(consoleInput.read())
    consoleOutput.printResultMessage(result)
}
