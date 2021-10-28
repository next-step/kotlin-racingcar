package racing.controller

import racing.domain.Cars
import racing.domain.GameResult
import racing.domain.Pedal
import racing.domain.RacingRounds
import racing.view.InputView
import racing.view.OutPutView

object RacingController {
    fun startRacing() {
        val (carNames, racingRounds) = getDataForRacing()
        val cars = Cars.make(carNames = carNames)
        val pedal = Pedal(4)

        printStart()
        val gameResult = racingRounds.raceDuringCountGivenByUser(cars = cars, pedal = pedal)
        printGameResult(gameResult)
    }

    private fun printGameResult(gameResult: GameResult) {
        OutPutView.printGameResult(gameResult)
    }

    private fun getDataForRacing(): Pair<List<String>, RacingRounds> {
        return Pair(InputView.getCar(), RacingRounds.make(InputView.getRound()))
    }

    private fun printStart() {
        OutPutView.printStart()
    }
}
