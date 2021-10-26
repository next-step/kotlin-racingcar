package racing.controller

import racing.domain.Cars
import racing.domain.Pedal
import racing.domain.RacingRounds
import racing.domain.RoundResult
import racing.view.InputView
import racing.view.OutPutView

object RacingController {
    fun startRacing() {
        val (carNames, racingRounds) = getDataForRacing()
        val cars = Cars.make(carNames = carNames)
        val pedal = Pedal(4)

        printStart()
        val roundResults = racingRounds.raceDuringCountGivenByUser(cars = cars, pedal = pedal)
        printRound(roundResults)
        printResult(cars)
    }

    private fun getDataForRacing(): Pair<List<String>, RacingRounds> {
        return Pair(InputView.getCar(), RacingRounds.make(InputView.getRound()))
    }

    private fun printStart() {
        OutPutView.printStart()
    }

    private fun printRound(roundData: Array<RoundResult>) {
        OutPutView.printRound(roundData)
    }

    private fun printResult(cars: Cars) {
        OutPutView.printResult(cars)
    }
}
