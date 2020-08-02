package racingcar.controller

import racingcar.model.Car
import racingcar.model.RacingGame
import racingcar.model.Winner
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val (racingCarNames, tryCounts) = InputView.requestRacingCarNames() to InputView.requestTryCount()
    val racingGame = RacingGame(racingCarNames.map(::Car))
    val winner = Winner(racingGame)

    racingGame.play(tryCounts)
    ResultView.printRacingProcess(racingGame)
    ResultView.printRacingWinner(winner)
}
