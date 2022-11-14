package racingcarWinner

import racingcarWinner.core.WinnerRacing
import racingcarWinner.ui.InputView
import racingcarWinner.ui.OutputView

fun main() {
    val carNameList = InputView.inputCarNames()
    val tryNumber = InputView.inputTryNumber()

    val racing = WinnerRacing()

    val cars = racing.setCars(carNameList)

    OutputView.outputResult(cars, racing, tryNumber)

    OutputView.outputWinner(cars, racing)
}
