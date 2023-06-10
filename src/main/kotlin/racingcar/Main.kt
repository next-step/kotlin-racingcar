package racingcar

import racingcar.io.InputView
import racingcar.io.ResultView

fun main() {
    val input = InputView().getInput()
    ResultView().printGame(input)
}
