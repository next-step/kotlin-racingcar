import view.InputView
import view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    resultView.printRacingGame(inputView.inputRetryCount(), inputView.inputCarNames())
}
