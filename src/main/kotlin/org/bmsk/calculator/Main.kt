package org.bmsk.calculator

import org.bmsk.calculator.model.StringFormula

fun main() {
    print("문자열 수식을 입력: ")
    val input = readlnOrNull() ?: ""
    val stringFormula = StringFormula(input)

    try {
        val result = stringFormula.calculate()
        println("계산 결과는 $result")
    } catch (e: Exception) {
        println("잘못된 문자열 수식입니다.")
    }
}
