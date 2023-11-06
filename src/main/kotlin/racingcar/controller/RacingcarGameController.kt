package racingcar.controller

import racingcar.RacingcarGame
import racingcar.view.RacingcarGameInputView
import racingcar.view.RacingcarGameResultView

class RacingcarGameController(
    private val inputView: RacingcarGameInputView,
    private val resultView: RacingcarGameResultView,
    private val game: RacingcarGame
) {

    fun startGame() {
        val input = inputView.getInput()
        val result = game.play(input)

        resultView.printGameResult(result)
    }
}
