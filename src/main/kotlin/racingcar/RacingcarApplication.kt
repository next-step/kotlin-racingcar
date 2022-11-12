package racingcar

import racingcar.io.InputView
import racingcar.strategy.RandomMoveStrategy

fun main() {
    val nameOfCars = InputView.getNameOfCars()
    val numberOfAttempts = InputView.getNumberOfAttempts()
    RacingGameController.play(nameOfCars, numberOfAttempts, RandomMoveStrategy())
}
