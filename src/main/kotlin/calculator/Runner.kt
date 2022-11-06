package calculator

import calculator.application.StringCalculator
import calculator.ui.inputExpression

fun main(args: Array<String>) {
    val result = StringCalculator().calculate(inputExpression(System.`in`))
    println(result)
}