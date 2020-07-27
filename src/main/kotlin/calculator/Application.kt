package calculator

import isInvalid

fun main() {
    val view = CalculatorView()
    var expression = ExpressionParser.parse(view.inputExpression())

    while (!InputValidator.isValidExpression(expression)) {
        view.printInvalidExpression()
        expression = ExpressionParser.parse(view.inputExpression())
    }

    when {
        Calculator.execute(expression).isInvalid() -> view.printImpossibleCalculate()
        else -> view.printResult(Calculator.execute(expression))
    }
}
