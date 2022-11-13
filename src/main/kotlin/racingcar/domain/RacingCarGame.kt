package racingcar.domain

import racingcar.model.GameInfo
import racingcar.ui.InputView
import racingcar.ui.ResultView

class RacingCarGame {

    fun run() {
        showResult(getGameInfo())
    }

    private fun getGameInfo(): GameInfo = GameInfo(
        carNumber = InputView.getCarNumber(),
        trialNumber = InputView.getTrialNumber()
    )

    private fun showResult(gameInfo: GameInfo) {
        val cars = List(gameInfo.carNumber) { Car() }
        ResultView.printResultMessage()
        repeat(gameInfo.trialNumber) { round ->
            val resultOfRound = proceedRound(cars)
            ResultView.printTraceOfRound(round, resultOfRound)
        }
    }

    fun proceedRound(cars: List<Car>): List<Car> {
        cars.forEach {
            it.takeAction()
        }
        return cars
    }
}
