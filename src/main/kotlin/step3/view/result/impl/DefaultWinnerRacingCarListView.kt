package step3.view.result.impl

import step3.domain.RacingGame
import step3.view.result.WinnerRacingCarListView

class DefaultWinnerRacingCarListView : WinnerRacingCarListView {
    override fun printWinnerRacingCarList(racingGame: RacingGame) {
        val winnerRacingCarResult = racingGame.getWinnerRacingCarList().joinToString(", ") { it.name }
        println("${winnerRacingCarResult}가 최종 우승하셨습니다.")
    }
}
