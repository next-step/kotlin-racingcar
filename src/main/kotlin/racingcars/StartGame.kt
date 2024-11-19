package racingcars

import racingcars.ui.InputView
import racingcars.ui.ResultView

fun main() {
    val inputView = InputView { readln() }
    val resultView = ResultView()
    val randomNumberGenerator = SingleDigitRandomNumberGenerator()
    val gameManager = GameManager(inputView, resultView, randomNumberGenerator)
    gameManager.start()
}
