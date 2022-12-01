package study.racingcar.controller

import study.racingcar.domain.car.CarFactory
import study.racingcar.domain.generator.Generator
import study.racingcar.domain.racing.RacingGame
import study.racingcar.domain.racing.Winner
import study.racingcar.view.InputView
import study.racingcar.view.OutputView

class RacingController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val generator: Generator
) {
    fun racing() {
        val names = inputView.getCarsName()
        val round = inputView.getRound()

        val cars = CarFactory.createCars(names)
        val racingGame = RacingGame(cars, round)
        val racingResult = racingGame.run(generator)

        outputView.printResult(racingResult)
        outputView.printWinners(Winner(cars))
    }
}
