package src.racingcar

import src.racingcar.view.InputView
import src.racingcar.view.ResultView

object RacingCarGame {
    fun startGame() {
        val inputValue = InputView.executeInputScreen()
        ResultView.printRacingCarGameResult(inputValue.tryCount, inputValue.carNames)
    }
}

fun main() {
    RacingCarGame.startGame()
}
