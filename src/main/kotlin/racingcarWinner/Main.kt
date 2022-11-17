package racingcarWinner

import racingcarWinner.domain.CarList
import racingcarWinner.ui.InputView
import racingcarWinner.ui.OutputView

fun main() {
    val carNameList = InputView.inputCarNames()
    val tryNumber = InputView.inputTryNumber()

    val cars = CarList.setCars(carNameList)

    OutputView.outputResult(cars, tryNumber)

    OutputView.outputWinner(cars)
}
