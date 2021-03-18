package racingcar

import racingcar.domain.Cars
import racingcar.domain.RacingCarGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val carNames = inputView.carNames()
    val attemptCount = inputView.attemptCount()
    ResultView(
        RacingCarGame(Cars(carNames)).play(attemptCount = attemptCount)
    ).print()
}
