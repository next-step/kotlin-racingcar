package calculator

import calculator.domain.Calculator
import calculator.presentation.InputView
import calculator.presentation.OutputView

fun calculator() {
    OutputView.printStartCalculator()

    val calculateResult = Calculator.calculate(
        inputString = InputView.readInput(),
    )

    OutputView.printResultCalculator(
        result = calculateResult.toString(),
    )
}
