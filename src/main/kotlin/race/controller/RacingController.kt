package race.controller

import race.model.Race
import race.view.InputView
import race.view.ResultView

class RacingController(
    private val inputView: InputView = InputView,
    private val resultView: ResultView = ResultView,
) {

    fun start() {
        val racers = inputView.inputRacers()
        val numberOfRace = inputView.inputNumberOfRace()

        val cars = Race.createCars(carRacers = racers)
        val race = Race(cars, numberOfRace)

        resultView.showResult()

        race.startRacing {
            resultView.showRacing(it)
        }

        resultView.showWinner(race.getWinner())
    }
}
