package step2

import step2.calculator.Calculator.calculate
import step2.calculator.Input

fun main() {
    println("사칙 연산을 수행할 문자열을 입력해주세요")

    val input = Input()
    val givenExpression = input.inputString()

    println(calculate(givenExpression))
}
