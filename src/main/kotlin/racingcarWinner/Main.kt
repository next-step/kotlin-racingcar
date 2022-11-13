package racingcarWinner

import racingcarWinner.core.WinnerRacing
import racingcarWinner.ui.InputView
import racingcarWinner.ui.OutputView

fun main() {
    val carNameList = InputView.inputCarNames()
    val tryNumber = InputView.inputTryNumber()

    val racing = WinnerRacing()
    racing.setCars(carNameList)

    OutputView.outputResult(racing, tryNumber)

    OutputView.outputWinner(racing)
}
