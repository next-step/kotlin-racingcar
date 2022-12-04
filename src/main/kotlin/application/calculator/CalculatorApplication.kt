package application.calculator

import domain.caculator.Calculator
import util.calculator.converter.ExpressionConverter
import view.calculator.InputView
import view.calculator.OutputView

fun main() {
    val expression = InputView.inputExpression()
    val calculator = Calculator()

    val result = calculator.calculate(ExpressionConverter.convert(expression))

    OutputView.printResult(result)
}
