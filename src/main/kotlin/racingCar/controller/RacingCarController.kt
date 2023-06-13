package racingCar.controller

import racingCar.domain.Car
import racingCar.domain.Race
import racingCar.view.InputView
import racingCar.view.printResult
import racingCar.view.printStart

class RacingCarController {
    fun main() {
        val numberOfCar = InputView.getNumberOfCar()
        val numberOfRace = InputView.getNumberOfTrial()

        val cars = createCars(numberOfCar)
        printStart()
        for (i in 1..numberOfRace) {
            val race = Race(cars)
            race.racing()
            printResult(cars)
        }
    }

    private fun createCars(count: Int): List<Car> {
        val cars = mutableListOf<Car>()
        repeat((1..count).count()) {
            cars.add(Car())
        }
        return cars
    }
}
