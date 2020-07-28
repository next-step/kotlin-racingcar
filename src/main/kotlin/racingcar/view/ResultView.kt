package racingcar.view

object ResultView {
    private const val RESULT = "실행 결과"
    private const val WINNER = "가 최종 우승했습니다."

    fun printResultTitle() {
        println(RESULT)
    }

    fun printMovingStatus(status: String) {
        println(status)
    }
}
