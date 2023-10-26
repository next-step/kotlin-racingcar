package calculator

import calculator.app.StringCalculator
import calculator.present.ConsolePresenter

fun main() {
    val presenter = ConsolePresenter()
    val calculator = StringCalculator()

    val actual = calculator.calculate(presenter.requestInput())
    presenter.resultOutput(actual)
}
