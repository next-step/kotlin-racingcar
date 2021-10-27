package racingcar.resultviews

import racingcar.WinnerFinder
import racingcar.dtos.GameResult
import racingcar.dtos.RoundResult

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
        val winners = winnerFinder.find(gameResult).joinToString(WINNERS_SEPARATOR) { it.name }
        println("$winners 가 최종 우승했습니다.")
    }

    companion object {
        const val WINNERS_SEPARATOR = ", "
    }
}
