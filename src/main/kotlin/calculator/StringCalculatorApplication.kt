package calculator

import calculator.domain.StringCalculator
import calculator.ui.StringCalculatorView

fun main() = StringCalculatorApplication(StringCalculatorView(), StringCalculator())
    .run()

class StringCalculatorApplication(
    private val view: StringCalculatorView,
    private val calculator: StringCalculator
) {
    fun run() {
        view.welcome()
        val input = view.input()
        val output = calculator.execute(input)
        view.output(output)
    }
}
