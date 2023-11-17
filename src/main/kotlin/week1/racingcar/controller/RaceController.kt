package week1.racingcar.controller

import week1.racingcar.domain.Car
import week1.racingcar.domain.RacingGame
import week1.racingcar.view.InputView
import week1.racingcar.view.ResultView

class RaceController {

    fun startRacing() {
        val raceInfo = InputView.getValidateRaceInfo()
        val racingGame = RacingGame(createCars(raceInfo.cars), raceInfo.timesToRace)

        while (racingGame.isPlaying()) {
            val resultCarListAfterDriving = racingGame.driveOneTurn()
            ResultView.showResult(resultCarListAfterDriving)
        }
        ResultView.showWinner(racingGame.filterWinners())
    }

    private fun createCars(carNames: List<String>) = carNames.map { Car(it) }
}

fun main() {
    RaceController().startRacing()
}
