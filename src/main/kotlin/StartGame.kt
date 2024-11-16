import ui.InputView
import ui.ResultView

fun main() {
    val gameManager = GameManager()
    gameManager.inputView = InputView { readln() }
    gameManager.resultView = ResultView()
    gameManager.randomNumberGenerator = SingleDigitRandomNumberGenerator()
    gameManager.start()
}
