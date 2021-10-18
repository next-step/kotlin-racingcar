package racingcar.domain

import racingcar.service.CarMoveForwardDecider
import racingcar.view.input.InputView
import racingcar.view.result.ResultView

class RacingGame(
    inputView: InputView,
    private val resultView: ResultView,
    private val carMoveForwardStrategy: CarMoveForwardDecider
) {
    private val carNames: CarNames = inputView.getCarNames()
    private val numberOfTrials: NumberOfTrials = inputView.getNumberOfTrials()
    private val cars = Cars(carNames)

    fun proceed() {
        resultView.showTitle()
        repeat(numberOfTrials.value) {
            cars.moveForward(carMoveForwardStrategy)
            resultView.showStatuses(cars)
        }
        resultView.showWinners(cars)
    }
}
