package racingcar

import racingcar.io.InputView

fun main() {
    val (numberOfCars, numberOfAttempts) = InputView.getCommandLineInput()
    RacingGame.play(numberOfCars, numberOfAttempts, MoveType.DEFAULT)
}
