package study.step3

import study.step3.generator.RandomNumberGenerator
import study.step3.io.InputView
import study.step3.io.OutputView
import study.step3.racing.RacingGame

fun main() {
    val carCount = InputView.getCountOfCars()
    val attempts = InputView.getCountOfAttempts()

    val racingGame = RacingGame(carCount, attempts)
    val generator = RandomNumberGenerator(MAX_RANDOM_NUMBER)
    val racingResult = racingGame.run(generator)

    racingResult.forEach { attemptResult ->
        OutputView.showResult(attemptResult)
    }
}

const val MAX_RANDOM_NUMBER = 9
