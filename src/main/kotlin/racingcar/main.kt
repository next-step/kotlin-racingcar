package racingcar

import racingcar.ui.InputView
import racingcar.ui.ResultView

val inputView = InputView()
val resultView = ResultView()

fun main() {
    val racingGame = inputView.inputRacingGame()
    val numberOfAttempts = inputView.inputNumberOfAttempts()

    resultView.printResultTitle()
    repeat(numberOfAttempts) {
        resultView.printRacingRound(it)
        racingGame.move()

        val names = racingGame.names
        val movements = racingGame.movements
        resultView.printRacingCarMovements(names, movements)
    }
    resultView.printRacingWinners(racingGame.getWinners())
}
