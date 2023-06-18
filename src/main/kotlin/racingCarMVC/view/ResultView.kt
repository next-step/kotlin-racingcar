package racingCarMVC.view

import racingCarMVC.domain.dto.GameResult
import racingCarMVC.domain.dto.RacingResult

class ResultView {
    private fun showResultMessage() {
        println("실행 결과")
    }

    fun showRacingResult(racingResult: RacingResult) {
        this.showResultMessage()

        racingResult.gameResults.forEach {
            this.showCarPosition(it)
        }

        this.showWinners(racingResult.winners)
    }

    private fun showWinners(winners: List<String>) {
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }

    private fun showCarPosition(gameResult: GameResult) {
        gameResult.gameRecord.forEach { player ->
            println("${player.name} : ${DISPLAY_STRING.repeat(player.position)}")
        }
        println()
    }

    companion object {
        const val DISPLAY_STRING = "-"
    }
}
