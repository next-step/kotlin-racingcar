package calculator

import calculator.app.StringCalculator

fun main() {
    val calculator = StringCalculator()
    calculator.calculate(readlnOrNull())
}
