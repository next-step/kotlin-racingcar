package racingcar.controller

import racingcar.model.Car
import racingcar.model.RacingGame
import racingcar.model.Winner
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val (racingCarNames, tryCounts) = InputView.requestRacingCarNames() to InputView.requestTryCount()
    val racingCars = racingCarNames.map { Car(name = it, distance = 0) }
    val racingGame = RacingGame(racingCars)

    racingGame.play(tryCounts)

    showContents(racingGame, Winner.find(racingCars))
}

private fun showContents(racingGame: RacingGame, winners: List<String>) {
    ResultView.printRacingProcess(racingGame)
    ResultView.printRacingWinner(winners)
}
