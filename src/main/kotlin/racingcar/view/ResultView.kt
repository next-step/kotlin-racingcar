package racingcar.view

import racingcar.domain.Car

object ResultView {
    private const val RESULT = "실행 결과"
    private const val WINNER = "가 최종 우승했습니다."
    private const val NO_WINNER = "우승자가 없습니다."

    fun printResultTitle() {
        println(RESULT)
    }

    fun printMovingStatus(status: String) {
        println(status)
    }

    fun printWinners(winners: List<Car>) {
        if (winners.isEmpty()) {
            println(NO_WINNER)
        } else {
            println(winners.joinToString { it.getName() } + WINNER)
        }
    }
}
