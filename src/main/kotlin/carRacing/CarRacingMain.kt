package carRacing

import carRacing.view.InputView

fun main() {
    val inputView = InputView()

    val carCount: Int = inputView.readLineNumber("자동차 대수는 몇 대인가요?")

    val tryCount: Int = inputView.readLineNumber("시도할 횟수는 몇 회인가요?")

    println()
    println("실행 결과")
}
