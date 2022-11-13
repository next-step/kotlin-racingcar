package racingcar.domain

import racingcar.model.GameInfo
import racingcar.ui.InputView
import racingcar.ui.ResultView

class RacingCarGame {

    fun run() {
        showResult(getGameInfo())
    }

    private fun getGameInfo(): GameInfo = GameInfo(
        carNum = InputView.getCarNumber(),
        trialNum = InputView.getTrialNumber()
    )

    private fun showResult(gameInfo: GameInfo) {
        val cars = List(gameInfo.carNum) { Car() }
        ResultView.printResultMessage()
        repeat(gameInfo.trialNum) { round ->
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
