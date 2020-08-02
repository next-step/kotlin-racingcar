package racingcar.controller

import racingcar.model.Car
import racingcar.model.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val (racingCarNames, tryCounts) = InputView.requestRacingCarNames() to InputView.requestTryCount()
    val participant = RacingGame(racingCarNames.map(::Car))

    startRacing(tryCounts, participant)
    showContents(racingCarNames, participant)
}

private fun showContents(racingCarNames: List<String>, racingGame: RacingGame) {
    ResultView.printRacingProcess(racingCarNames, racingGame.movingDistanceHistory)
    ResultView.printRacingWinner(racingGame)
}

private fun startRacing(tryCounts: Int, racingGame: RacingGame) {
    racingGame.play(tryCounts)
}
