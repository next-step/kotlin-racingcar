package racingcar

import racingcar.domain.RacingCarNumberGenerator
import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val cars = InputView.readCars()
    val roundCount = InputView.readRoundCount()

    val racingGame = RacingGame(
        cars = cars,
        numberGenerator = RacingCarNumberGenerator()
    )

    repeat(roundCount) {
        val drivingCars = racingGame.round()
        ResultView.print(drivingCars)
    }
}
