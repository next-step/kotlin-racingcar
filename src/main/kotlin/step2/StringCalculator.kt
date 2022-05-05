package step2

/**
 * 문자열 사칙 연산 계산기
 * Created by Jaesungchi on 2022.05.05..
 */

fun main() {
    val calculator = StringCalculator()
    val input = readlnOrNull()
    val output = calculator.startCalculate(input)
    println(output)
}

class StringCalculator {
    /**
     * 문자열을 받고 계산을 시작하여 계산한값을 돌려준다.
     */
    fun startCalculate(input: String?): String {
        return input ?: ""
    }
}