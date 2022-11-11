package racingcar.view

object ResultView {
    fun executionResult() {
        println("실행 결과")
    }

    fun presentSituation(name: String, position: Int) {
        println("$name : ${"-".repeat(position)}")
    }

    fun getWinner(name: String) {
        println("${name}가 최종 우승했습니다.")
    }
}
