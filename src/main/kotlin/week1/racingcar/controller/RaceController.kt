package week1.racingcar.controller

import week1.racingcar.domain.Car
import week1.racingcar.domain.RacingGame
import week1.racingcar.view.InputView
import week1.racingcar.view.ResultView

class RaceController {

    fun startRacing() {
        val raceInfo = InputView.getValidateRaceInfo()
        val racingGame = RacingGame(raceInfo.cars.map { Car(it) }, raceInfo.timesToRace)

        repeat(racingGame.timesToRace) {
            val carsAfterDriving = racingGame.driveOneTurn()
            ResultView.showResult(carsAfterDriving)
        }
        ResultView.showWinner(racingGame.getWinners())
    }
}

fun main() {
    RaceController().startRacing()
}
