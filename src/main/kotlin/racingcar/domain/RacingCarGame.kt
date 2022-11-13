package racingcar.domain

import racingcar.model.GameInfo
import racingcar.ui.InputView
import racingcar.ui.ResultView

class RacingCarGame {

    fun run() {
        startGame(getGameInfo())
    }

    private fun getGameInfo(): GameInfo = GameInfo(
        carNumber = InputView.getCarNumber(),
        trialNumber = InputView.getTrialNumber()
    )

    private fun startGame(gameInfo: GameInfo) {
        val cars = List(gameInfo.carNumber) { Car() }
        showResult(gameInfo.trialNumber, cars)
    }

    private fun showResult(trialNumber: Int, cars: List<Car>) {
        ResultView.printResultMessage()
        repeat(trialNumber) { round ->
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
