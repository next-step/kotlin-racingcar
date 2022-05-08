package calculator

import calculator.model.Calculator
import calculator.view.InputView
import calculator.view.ResultView

fun main() {
    InputView.printInputMessage()
    val expression = InputView.inputExpression()

    val result = Calculator.calculate(expression)
    ResultView.printResult(result)
}
