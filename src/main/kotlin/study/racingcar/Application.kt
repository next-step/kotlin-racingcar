package study.racingcar

import study.racingcar.generator.RandomNumberGenerator
import study.racingcar.io.InputView
import study.racingcar.io.OutputView
import study.racingcar.racing.RacingGame

fun main() {
    val carCount = InputView.getCountOfCars()
    val attempts = InputView.getCountOfAttempts()

    val racingGame = RacingGame(carCount, attempts)
    val generator = RandomNumberGenerator()
    val racingResult = racingGame.run(generator)

    racingResult.forEach { attemptResult ->
        OutputView.showResult(attemptResult)
    }
}
