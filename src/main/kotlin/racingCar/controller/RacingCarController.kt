package racingCar.controller

import racingCar.domain.Car
import racingCar.view.InputView
import racingCar.view.ResultView
import kotlin.random.Random
import kotlin.random.nextInt

class RacingCarController {
    fun main() {
        val numberOfCar: Int = InputView.getNumberOfCar()
        val numberOfRace: Int = InputView.getNumberOfTrial()

        val cars = createCars(numberOfCar)
        ResultView.printStart()

        repeat(numberOfRace) {
            cars.forEach { car ->
                car.move(randomNumberGenerator())
            }
            ResultView.printResult(cars)
        }
    }

    private fun randomNumberGenerator(): Int {
        return Random.nextInt(0..9)
    }

    private fun createCars(count: Int): List<Car> {
        return List(count) { Car() }
    }
}
