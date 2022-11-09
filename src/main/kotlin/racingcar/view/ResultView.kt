package racingcar.view

object ResultView {
    fun executionResult() {
        println("실행 결과")
    }

    fun presentSituation(position: Int) {
        println("-".repeat(position))
    }
}
