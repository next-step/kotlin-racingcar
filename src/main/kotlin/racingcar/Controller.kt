package racingcar

import racingcar.domain.ForwardStrategy
import racingcar.domain.RacingCar
import racingcar.view.InputView
import racingcar.view.ResultView

class Controller(private val inputView: InputView, private val resultView: ResultView) {

    fun startRacing() {
        val inputCarNames = inputView.inputCarNames()
        val tryCount = inputView.inputTryCount()

        val racingCar = RacingCar(inputCarNames, tryCount)
        val moveHistory = racingCar.start(ForwardStrategy.RandomRangeForward)

        resultView.printRacing(moveHistory.moveHistory, tryCount)
        resultView.printWinningCars(moveHistory.getWinningCarNames())
    }
}
