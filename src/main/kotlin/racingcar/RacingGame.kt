package racingcar

import racingcar.domain.Car
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingGame private constructor(
    private val numOfCars: Int,
    private val numOfAttempts: Int
) {
    fun setUpCars(): List<Car> {
        return List(numOfCars) { Car.ofRandom() }
    }

    fun start(cars: List<Car>): List<Car> {
        ResultView.printResultText()
        repeat(numOfAttempts) {
            cars.forEach { it.move() }
            ResultView.printResultState(cars)
        }
        return cars
    }

    companion object of {
        fun of(numOfCars: Int, numOfAttempts: Int): RacingGame {
            return RacingGame(numOfCars, numOfAttempts)
        }
    }
}

fun main() {
    val inputs = InputView.gatherUserInput()
    val racingGame = RacingGame.of(inputs.numOfCars, inputs.numOfAttempts)
    val racingCars = racingGame.setUpCars()
    racingGame.start(racingCars)
}