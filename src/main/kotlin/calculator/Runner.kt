package calculator

import calculator.application.StringCalculator
import calculator.ui.inputExpression

fun main() {
    val result = StringCalculator().calculate(inputExpression())
    println(result)
}
