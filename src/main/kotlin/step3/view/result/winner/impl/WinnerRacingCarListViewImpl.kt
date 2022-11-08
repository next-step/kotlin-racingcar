package step3.view.result.winner.impl

import step3.domain.RacingGame
import step3.view.result.winner.WinnerRacingCarListView

class WinnerRacingCarListViewImpl : WinnerRacingCarListView {

    override fun printWinnerRacingCarList(racingGame: RacingGame) {
        val winnerRacingCarResult = racingGame.getWinnerRacingCarList().joinToString(", ") { it.name }
        println("${winnerRacingCarResult}가 최종 우승하셨습니다.")
    }
}
