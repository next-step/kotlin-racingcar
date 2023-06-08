package step2

import step2.domain.Calculator
import step2.presentation.InputView
import step2.presentation.OutputView

fun main() {
    OutputView.printStartCalculator()

    val calculateResult = Calculator.calculate(
        inputString = InputView.readInput(),
    )

    OutputView.printResultCalculator(
        result = calculateResult.toString(),
    )
}
