package racingcar

import racingcar.view.RacingcarGameInputView
import racingcar.view.RacingcarGameResultView

fun main() {
    val inputView = RacingcarGameInputView()
    val resultView = RacingcarGameResultView()
    val application = RacingcarGame(resultView)

    val input = inputView.getInput()

    application.play(input)
}
