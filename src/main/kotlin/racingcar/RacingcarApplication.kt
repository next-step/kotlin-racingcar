package racingcar

import racingcar.io.InputView

fun main() {
    val numberOfCars = InputView.getNumberOfCars()
    val numberOfAttempts = InputView.getNumberOfAttempts()
    RacingGameController.play(numberOfCars, numberOfAttempts, RandomMoveStrategy())
}
