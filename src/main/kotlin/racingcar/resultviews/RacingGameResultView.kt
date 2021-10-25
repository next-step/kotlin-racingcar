package racingcar.resultviews

import racingcar.dtos.GameResult
import racingcar.dtos.RoundResult

class RacingGameResultView : ResultView {
    override fun printResult(gameResult: GameResult) {
        for (roundResult in gameResult.roundResults) {
            printRoundResult(roundResult)
        }
        printWinners(gameResult)
    }

    private fun printRoundResult(roundResult: RoundResult) {
        for (carDto in roundResult.results) {
            print("${carDto.name}: ")
            println("-".repeat(carDto.position))
        }
        println("")
    }

    private fun printWinners(gamResult: GameResult) {
        val winners = gamResult.winners.joinToString(WINNERS_SEPARATOR) { it.name }
        println("$winners 가 최종 우승했습니다.")
    }

    companion object {
        const val WINNERS_SEPARATOR = ", "
    }
}
