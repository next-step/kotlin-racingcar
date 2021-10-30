package racingcar

import racingcar.domain.RacingGame
import racingcar.domain.WinnerFinder
import racingcar.views.inputviews.RacingGameInputView
import racingcar.views.resultviews.RacingGameResultView

fun main() {
    val inputView = RacingGameInputView()
    val gameInput = inputView.receiveInput()

    val game = RacingGame(gameInput)
    val gameResult = game.play()

    val resultView = RacingGameResultView(WinnerFinder())
    resultView.printResult(gameResult)
}
