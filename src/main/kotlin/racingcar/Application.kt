package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carCount = InputView.inputCarCount()
    val tryCount = InputView.inputTryCount()

    ResultView.printResultTitle()
}
