package step3

import step3.ui.InputView
import step3.ui.ResultView

fun main() {
    val gameManager = GameManager()
    gameManager.inputView = InputView { readln() }
    gameManager.resultView = ResultView()
    gameManager.randomNumberGenerator = SingleDigitRandomNumberGenerator()
    gameManager.start()
}
