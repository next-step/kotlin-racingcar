package step3.view.result.winner.impl

import step3.domain.game.RacingGame
import step3.view.result.winner.RacingGameWinnerView

class RacingGameWinnerViewImpl : RacingGameWinnerView {

    override fun printRacingGameWinner(racingGame: RacingGame) {
        val winnerRacingCars = racingGame.getWinnerRacingCarList().joinToString(", ") { it.name }
        println("${winnerRacingCars}가 최종 우승했습니다.")
    }
}
