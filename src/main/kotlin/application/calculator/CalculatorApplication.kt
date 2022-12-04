package application.calculator

import util.calculator.converter.ExpressionConverter
import view.calculator.InputView
import view.calculator.OutputView

fun main() {
    val expression = InputView.inputExpression()
    val convertingExpression = ExpressionConverter.convert(expression)

    val result = convertingExpression.fold(0) { number1, (operator, number2) ->
        operator.calculate(number1, number2)
    }

    OutputView.printResult(result)
}
