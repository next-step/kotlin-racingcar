package step2

import step2.domain.Calculator
import step2.domain.CalculatorInputConverter
import step2.presentation.InputView
import step2.presentation.OutputView

fun main() {
    OutputView.printStartCalculator()

    val calculatorInput = CalculatorInputConverter.convertToCalculatorInput(
        inputString = InputView.readInput(),
    )

    OutputView.printResultCalculator(
        result = Calculator.calculate(
            calculatorInput = calculatorInput,
        ).toString(),
    )
}
