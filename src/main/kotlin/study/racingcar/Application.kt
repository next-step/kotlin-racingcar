package study.racingcar

import study.racingcar.car.CarFactory
import study.racingcar.generator.RandomNumberGenerator
import study.racingcar.io.InputView
import study.racingcar.io.OutputView
import study.racingcar.racing.RacingGame

fun main() {
    val names = InputView.getCarsName()
    val attempts = InputView.getAttempts()

    val cars = CarFactory.createCars(names)
    val generator = RandomNumberGenerator()

    val racingGame = RacingGame(cars, attempts)
    val racingResult = racingGame.run(generator)

    racingResult.forEach { attemptResult ->
        OutputView.showResult(attemptResult)
    }
}
