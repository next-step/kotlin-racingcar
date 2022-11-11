package racingcar.view

object ResultView {
    fun executionResult() {
        println("실행 결과")
    }

    fun presentSituation(name: String, position: Int) {
        println("$name : ${"-".repeat(position)}")
    }
}
