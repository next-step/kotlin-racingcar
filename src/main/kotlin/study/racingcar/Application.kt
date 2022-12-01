package study.racingcar

import study.racingcar.car.CarFactory
import study.racingcar.generator.RandomNumberGenerator
import study.racingcar.io.InputView
import study.racingcar.io.OutputView
import study.racingcar.racing.RacingGame
import study.racingcar.racing.Winner

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
