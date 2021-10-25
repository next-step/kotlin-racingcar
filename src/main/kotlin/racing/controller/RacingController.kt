package racing.controller

import racing.domain.Cars
import racing.domain.Pedal
import racing.domain.Round
import racing.view.InputView
import racing.view.OutPutView

object RacingController {
    fun startRacing() {
        val (carNames, round) = getDataForRacing()
        val cars = Cars.make(carNames = carNames)
        val pedal = Pedal(4)

        printStart()
        val roundData = round.raceForRound(cars = cars, pedal = pedal)
        printRound(roundData)
        printResult(cars)
    }

    private fun getDataForRacing(): Pair<List<String>, Round> {
        return Pair(InputView.getCar(), Round.make(InputView.getRound()))
    }

    private fun printStart() {
        OutPutView.printStart()
    }

    private fun printRound(roundData: Array<List<Pair<String, Int>>>) {
        OutPutView.printRound(roundData)
    }

    private fun printResult(cars: Cars) {
        OutPutView.printResult(cars)
    }
}
