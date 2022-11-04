package study

import study.step2.Calculator

fun main() {
    print("계산식을 입력해주세요 : ")
    val value: String = readLine()!!

    val calculator = Calculator()
    val result = calculator.calc(value)
    print("계산식의 결과는  $result 입니다")
}
