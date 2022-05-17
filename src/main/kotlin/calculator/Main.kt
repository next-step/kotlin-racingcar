package calculator

import java.util.Scanner

fun main() {
    val input = InputView().input()
    val result = StringCalculator().calculate(input)
    OutputView().output(result)
}

class InputView(private val scanner: Scanner = Scanner(System.`in`)) {
    fun input(): String {
        print("식을 입력해주세요: ")
        return scanner.nextLine()
    }
}

class OutputView() {
    fun output(result: Double) {
        println("결과: $result")
    }
}
