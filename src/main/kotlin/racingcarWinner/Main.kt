package racingcarWinner

import racingcarWinner.domain.Cars
import racingcarWinner.ui.InputView
import racingcarWinner.ui.OutputView

fun main() {
    val carNameList = InputView.inputCarNames()
    val tryNumber = InputView.inputTryNumber()

    val cars = Cars(carNameList).carList

    OutputView.outputResult(cars, tryNumber)

    OutputView.outputWinner(cars)
}
