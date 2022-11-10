package racingcar

import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    InputView.input()

    val carNumber = InputView.carNumber
    val tryNumber = InputView.tryNumber

    ResultView.output(carNumber, tryNumber)
}
