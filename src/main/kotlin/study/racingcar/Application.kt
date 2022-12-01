package study.racingcar

import study.racingcar.domain.car.CarFactory
import study.racingcar.domain.generator.RandomNumberGenerator
import study.racingcar.domain.racing.RacingGame
import study.racingcar.domain.racing.Winner
import study.racingcar.io.InputView
import study.racingcar.io.OutputView

fun main() {
    val names = InputView.getCarsName()
    val round = InputView.getRound()

    val cars = CarFactory.createCars(names)
    val generator = RandomNumberGenerator()

    val racingGame = RacingGame(cars, round)
    val racingResult = racingGame.run(generator)

    OutputView.printResult(racingResult)
    OutputView.printWinners(Winner(cars))
}
