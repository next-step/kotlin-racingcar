package step2

import step2.calculator.StringCalculator

fun main() {
    println("사칙연산식을 입력해주세요 ")
    val input = readlnOrNull()
    val result = StringCalculator.execute(input)

    println(result)
}
