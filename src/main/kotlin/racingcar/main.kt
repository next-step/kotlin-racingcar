package racingcar

import racingcar.ui.InputView
import racingcar.ui.ResultView

val inputView = InputView()
val resultView = ResultView()

fun main() {
    val racingGame = inputView.inputRacingGame()
    val numberOfAttempts = inputView.inputNumberOfAttempts()

    resultView.printRaceProgress(racingGame, numberOfAttempts)
}
