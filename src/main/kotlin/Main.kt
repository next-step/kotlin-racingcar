import presentation.view.InputView
import presentation.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    resultView.printRacingGame(inputView.inputRetryCount(), inputView.inputCarNames())
}
