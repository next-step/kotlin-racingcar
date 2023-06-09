package study

import calculator.Calculator

fun main() {
    val expression = "2 + 3 * 4 / 2"
    println("입력 $expression")
    val result = Calculator.execute(expression)
    println("실행결과 $result")
}
