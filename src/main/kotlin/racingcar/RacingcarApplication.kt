package racingcar

import racingcar.io.InputView

fun main() {
    val nameOfCars = InputView.getNameOfCars()
    val numberOfAttempts = InputView.getNumberOfAttempts()
    RacingGameController.play(nameOfCars, numberOfAttempts, RandomMoveStrategy())
}
