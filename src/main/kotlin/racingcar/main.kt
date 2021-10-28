package racingcar

import racingcar.inputviews.RacingGameInputView
import racingcar.resultviews.RacingGameResultView

fun main() {
    val inputView = RacingGameInputView()
    val gameInput = inputView.receiveInput()

    val game = RacingGame(gameInput)
    val gameResult = game.play()

    val winnerFinder = WinnerFinder()
    val resultView = RacingGameResultView(winnerFinder)
    resultView.printResult(gameResult)
}
