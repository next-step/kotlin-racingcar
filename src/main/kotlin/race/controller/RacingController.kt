package race.controller

import race.model.Race
import race.view.InputView
import race.view.ResultView

class RacingController(
    private val inputView: InputView = InputView,
    private val resultView: ResultView = ResultView,
) {

    fun start() {
        val numberOfCar = inputView.inputNumberOfCar()
        val numberOfRace = inputView.inputNumberOfRace()
        val race = Race(numberOfCar)

        resultView.showResult()
        // resultView.showRacing(racing.cars)

        repeat(numberOfRace) {
            race.carsMove()
            val cars = race.cars.map { it.position }
            resultView.showRacing(cars)
        }
    }
}
