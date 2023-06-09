package step3.controller

import step3.model.Car
import step3.model.NumberGenerator
import step3.model.RacingGame
import step3.model.RandomNumberGenerator
import step3.view.InputView
import step3.view.OutputView

class GameController(
    private val numberOfCars: Int = InputView.requestNumberOfCars(),
    private val totalTrialCount: Int = InputView.requestCountOfTrial(),
    private val numberGenerator: NumberGenerator = RandomNumberGenerator()
) {

    fun start() {
        val cars = createCars(numberOfCars)
        val racingGame = RacingGame(numberGenerator, cars)

        OutputView.printResult()
        while (racingGame.getCurrentTrialCount() < totalTrialCount) {
            racingGame.run()
            val results = racingGame.getResult()
            OutputView.printByResults(results)
        }
    }

    private fun createCars(numberOfCars: Int): List<Car> {
        val cars = mutableListOf<Car>()
        for (i in 1..numberOfCars) {
            cars.add(Car(number = i))
        }
        return cars.toList()
    }
}
