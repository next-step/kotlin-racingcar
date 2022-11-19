package racingcar

import racingcar.io.InputView
import racingcar.io.OutputView
import racingcar.strategy.RandomMoveStrategy

fun main() {
    val nameOfCars = InputView.getParticipateCarNames()
    val numberOfAttempts = InputView.getNumberOfAttempts()

    val winners = RacingGameController.play(nameOfCars, numberOfAttempts, RandomMoveStrategy())

    OutputView.showWinners(winners)
}
