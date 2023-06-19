package race.controller

import race.model.Race
import race.model.Winner
import race.view.InputView
import race.view.ResultView

class RacingController(
    private val inputView: InputView = InputView,
    private val resultView: ResultView = ResultView,
) {

    fun ready() {
        val racers = inputView.inputRacers()
        val numberOfRace = inputView.inputNumberOfRace()

        val cars = Race.createCars(carRacers = racers)
        val race = Race(cars, numberOfRace)

        start(race)
    }

    private fun start(race: Race) {
        resultView.showResult()
        val winner = race.start {
            resultView.showRacing(it)
        }

        result(winner)
    }

    private fun result(winner: Winner) {
        resultView.showWinner(winner.getWinner())
    }
}
