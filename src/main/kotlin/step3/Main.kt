package step3

import step3.car.CarService
import step3.race.RaceService
import step3.view.InputView

fun main() {

    val inputView = InputView()
    inputView.readInRoundSize()

    val carService = CarService()
    carService.initCars()

    val raceService = RaceService()
    raceService.runRacingByRound()
}
