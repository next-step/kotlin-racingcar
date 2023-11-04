package racingcar

import racingcar.view.RacingcarGameInputView
import racingcar.view.RacingcarGameResultView

fun main() {
    val inputView = RacingcarGameInputView()
    val resultView = RacingcarGameResultView()
    val application = RacingcarGame()

    val input = inputView.getInput()
    val result = application.play(input)

    resultView.printGameResult(result)
}
