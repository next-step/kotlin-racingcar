package calculator

import java.util.Scanner

fun main() {
    print("연산을 수행할 문자열을 입력해주세요: ")
    val scanner = Scanner(System.`in`)
    println(StringCalculator.calculate(scanner.nextLine()))
}
