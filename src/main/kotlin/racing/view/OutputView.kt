package racing.view

import racing.model.Car
import racing.model.RacingHistory

class OutputView {

    fun printRacingHistory(racingHistory: RacingHistory) {
        println("실행 결과")
        for (roundHistory in racingHistory.roundHistories) {
            println(ConsoleRender.roundRendering(roundHistory) + "\n")
        }
    }

    fun printWinner(racingHistory: RacingHistory) {
        println("${joinWinners(racingHistory.winners())} 가 최종 우승했습니다.")
    }

    private fun joinWinners(winners: Set<Car>): String {
        return winners.joinToString(separator = ", ") { it.name.value }
    }
}
