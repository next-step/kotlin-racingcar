package racingcar.domain

import racingcar.model.GameInfo
import racingcar.ui.InputView
import racingcar.ui.ResultView

class RacingCarGame {

    fun run() {
        startGame(getGameInfo())
    }

    private fun getGameInfo(): GameInfo = GameInfo(
        carInfo = InputView.getCarInfo(),
        trialCount = InputView.getTrialCount()
    )

    private fun startGame(gameInfo: GameInfo) {
        val cars = gameInfo.carInfo.names.map { name ->
            Car(name = name)
        }
        showResultOfRounds(gameInfo.trialCount, cars)
    }

    private fun showResultOfRounds(trialCount: Int, cars: List<Car>) {
        ResultView.printResultMessage()
        repeat(trialCount) { round ->
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
