package racingcar

import racingcar.view.RacingcarGameInputView

fun main() {
    val inputView = RacingcarGameInputView()
    val application = RacingcarGame()

    val input = inputView.getInput()

    application.play(input)
}
