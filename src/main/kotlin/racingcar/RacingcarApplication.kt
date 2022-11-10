package racingcar

import racingcar.io.InputView

fun main() {
    val numberOfCars = InputView.getNumberOfCars()
    val numberOfAttempts = InputView.getNumberOfAttempts()
    RacingGame.play(numberOfCars, numberOfAttempts, RandomMoveStrategy())
}
