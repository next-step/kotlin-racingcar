package calculator

import calculator.validator.OperationValidator
import java.util.Scanner

fun main() {
    CalculatorMain().startCalculator()
}

class CalculatorMain {
    fun startCalculator() {
        println("사칙연산을 위한 숫자와 연산자를 입력하세요. \n각 연산자 사이는 공백으로 분리하세요. (ex: 1 + 3 * 5)")

        val scanner = Scanner(System.`in`)
        while (true) {
            val expression = scanner.nextLine()

            try {
                if (!OperationValidator.isCorrectExpression(expression)) throw IllegalArgumentException("잘못된 입력입니다.")
                val result = Calculator.calculate(expression)
                println("결과: $result")
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}
