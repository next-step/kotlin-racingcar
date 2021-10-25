package racingcar.resultviews

import racingcar.dtos.GameResult
import racingcar.dtos.RoundResult

class RacingGameResultView : ResultView {
    override fun printResult(gameResult: GameResult) {
        for (roundResult in gameResult.roundResults) {
            printRoundResult(roundResult)
        }
    }

    private fun printRoundResult(roundResult: RoundResult) {
        for (carDto in roundResult.results) {
            print("${carDto.name}: ")
            println("-".repeat(carDto.position))
        }
        println("")
    }
}
