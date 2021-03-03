package calculator

import calculator.domain.StringCalculator
import calculator.ui.inputExpression

fun main(args: Array<String>) {
    val inputExpression = inputExpression(System.`in`)
    val result = StringCalculator().calculate(inputExpression)
    println(result)
}
