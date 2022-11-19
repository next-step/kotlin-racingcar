package racingcar

import racingcar.controller.RacingGameController
import racingcar.domain.strategy.RandomMoveStrategy
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val nameOfCars = InputView.getParticipateCarNames()
    val numberOfAttempts = InputView.getNumberOfAttempts()

    val winners = RacingGameController.play(nameOfCars, numberOfAttempts, RandomMoveStrategy())

    OutputView.showWinners(winners)
}
