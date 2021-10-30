package racingcar.views.resultviews

import racingcar.domain.WinnerFinder
import racingcar.domain.dtos.GameResult
import racingcar.domain.dtos.RoundResult

class RacingGameResultView(private val winnerFinder: WinnerFinder) : ResultView {
    override fun printResult(gameResult: GameResult) {
        for (roundResult in gameResult.roundResults) {
            printRoundResult(roundResult)
        }
        printWinners(gameResult)
    }

    private fun printRoundResult(roundResult: RoundResult) {
        for (car in roundResult.cars) {
            print("${car.name}: ")
            println("-".repeat(car.position))
        }
        println("")
    }

    private fun printWinners(gameResult: GameResult) {
        val winners = winnerFinder
            .find(gameResult)
            .joinToString { it.name }
        println("$winners 가 최종 우승했습니다.")
    }
}
