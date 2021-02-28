package calculator

import calculator.console.ConsoleInput
import calculator.console.ConsoleOutput
import calculator.notation.SequencePostfixNotationTransformer

fun main() {
    val input = ConsoleInput()
    val output = ConsoleOutput()
    val calculator = Calculator()
    val notationTransformer = SequencePostfixNotationTransformer()

    val words = notationTransformer.transform(input.read())
    val result = calculator.calculate(words)
    output.write(result)
}
