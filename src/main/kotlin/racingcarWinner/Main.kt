package racingcarWinner

import racingcarWinner.core.CarList
import racingcarWinner.core.Winner
import racingcarWinner.ui.InputView
import racingcarWinner.ui.OutputView

fun main() {
    val carNameList = InputView.inputCarNames()
    val tryNumber = InputView.inputTryNumber()

    val winner = Winner()

    val cars = CarList.setCars(carNameList)

    OutputView.outputResult(cars, winner, tryNumber)

    OutputView.outputWinner(cars, winner)
}
