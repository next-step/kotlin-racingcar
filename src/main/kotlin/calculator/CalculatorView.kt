package calculator

import toPrintString
import java.util.Scanner

class CalculatorView {
    private val scanner: Scanner = Scanner(System.`in`)

    fun inputExpression(): String {
        println(REQUEST_EXPRESSION)
        return scanner.nextLine()
    }

    fun printInvalidExpression() {
        println(ERR_INVALID_EXPRESSION)
    }

    fun printImpossibleCalculate() {
        println(IMPOSSIBLE_CALCULATE)
    }

    fun printResult(result: Double) {
        println("$CALCULATE_RESULT : ${result.toPrintString()}")
    }

    companion object {
        private const val REQUEST_EXPRESSION = "계산할 식을 입력해주세요. 숫자와 연산자는 띄어쓰기로 구분합니다. ex) 2 + 3 * 4 / 2"
        private const val ERR_INVALID_EXPRESSION = "올바른 형식의 식이 아닙니다."
        private const val IMPOSSIBLE_CALCULATE = "계산 불가"
        private const val CALCULATE_RESULT = "계산 결과"
    }
}
