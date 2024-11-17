package step3

import step3.ui.InputView
import step3.ui.ResultView

fun main() {
    val inputView = InputView { readln() }
    val resultView = ResultView()
    val randomNumberGenerator = SingleDigitRandomNumberGenerator()
    val gameManager = GameManager(inputView, resultView, randomNumberGenerator)
    gameManager.start()
}
