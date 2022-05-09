package racingcar

import racingcar.view.InputView
import racingcar.view.OutputView

object RacingCarGame {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun startGame() {
        val gameProperties = inputView.readGameProperties()

        val gameResult = GameRunner(gameProperties).start()

        outputView.printGameResult(gameResult)
    }
}

fun main() {
    RacingCarGame.startGame()
}