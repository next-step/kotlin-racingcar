package calculator

import calculator.console.ConsoleInput
import calculator.console.ConsoleOutput
import calculator.notation.SequencePostfixNotationTransformer

fun main() {
    val input = ConsoleInput()
    val calculator = SequenceCalculator(SequencePostfixNotationTransformer())

    calculator.parse(input.read())
    calculator.calculate()

    val result = calculator.result()

    val output = ConsoleOutput()
    output.write(result)
}
