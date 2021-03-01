package calculator

import calculator.ui.CalculatorController
import view.console.ConsoleInput
import view.console.ConsoleOutput

val consoleOutput: ConsoleOutput = ConsoleOutput()
val consoleInput: ConsoleInput = ConsoleInput()

fun main() {
    consoleOutput.printExpressionInputMessage()
    val result = CalculatorController().run(consoleInput.read())
    consoleOutput.printCalculatorResultMessage(result)
}
