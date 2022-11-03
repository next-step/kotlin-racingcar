package step2

import step2.config.ObjectAssemble
import step2.interfaces.input.InputConsole
import step2.interfaces.output.OutputConsole

fun main() {
    val expression = InputConsole.input()
    val calculatorView = ObjectAssemble.calculatorView()
    val result = calculatorView.calculate(expression)
    OutputConsole.output(result)
}
