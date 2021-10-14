package calculator

import calculator.application.StringCalculator
import calculator.domain.CalculatorFactory
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val expression = scanner.nextLine()
    val result = calculator().execute(expression)
    println("계산 결과 : $result")
}

private fun calculator(): StringCalculator {
    val calculators = CalculatorFactory.init()
    return StringCalculator(calculators)
}
