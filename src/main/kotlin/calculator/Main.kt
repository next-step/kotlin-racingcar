package calculator

import calculator.console.ConsoleInput
import calculator.console.ConsoleOutput

fun main() {
    val input = ConsoleInput()
    val calculator = SequenceCalculator()

    calculator.parse(input.read())
    calculator.calculate()

    val result = calculator.result()

    val output = ConsoleOutput()
    output.write(result)
}
