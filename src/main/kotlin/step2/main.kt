package step2

import step2.Calculator.calculate
import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    print("계산하고 싶은 수식을 입력하세요: ")
    val input = sc.nextLine()

    validateInput(input)
    val result = calculate(input)
    println("결과 = $result")
}

fun validateInput(input: String?) {
    require(!input.isNullOrBlank()) { ErrorMessage.INCORRECT_INPUT }
}
