package calculator

import calculator.domain.Calculator
import calculator.ui.inputExpression

fun main(args: Array<String>) {
    val inputExpression = inputExpression(System.`in`)
    val result = Calculator().calculate(inputExpression)
    println(result)
}
