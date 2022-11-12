package racingcar

import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val carNumber = InputView.inputCarNumber()
    val tryNumber = InputView.inputTryNumber()

    ResultView.output(carNumber, tryNumber)
}
