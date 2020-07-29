package racingcar.view

import racingcar.domain.Car

object ResultView {
    const val WINNER_MSG = "이/가 최종 우승했습니다."

    fun viewDistances(round: String) {
        round.forEach { print(it) }
        println()
    }

    fun viewWinner(winner: List<Car>) {
        println("${winner.joinToString { it.getName() }} $WINNER_MSG")
    }
}
