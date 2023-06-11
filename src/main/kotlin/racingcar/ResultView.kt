package racingcar

object ResultView {

    fun outputPosition(carPosition: Int) {
        repeat(carPosition) { print("-") }
        println()
    }

    fun outputResult() {
        println("실행 결과")
    }
}
