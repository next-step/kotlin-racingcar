package racingcar

import racingcar.inputviews.RacingGameInputView
import racingcar.resultviews.RacingGameResultView

fun main() {
    val inputView = RacingGameInputView()
    val gameInput = inputView.receiveInput()

    val game = RacingGame(gameInput)
    val gameResult = game.play()

    val resultView = RacingGameResultView(WinnerFinder())
    resultView.printResult(gameResult)
}
