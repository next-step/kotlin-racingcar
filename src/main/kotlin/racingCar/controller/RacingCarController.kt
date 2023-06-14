package racingCar.controller

import racingCar.domain.Car
import racingCar.domain.Race
import racingCar.view.InputView
import racingCar.view.ResultView

class RacingCarController {
    fun main() {
        val numberOfCar: Int = InputView.getNumberOfCar()
        val numberOfRace: Int = InputView.getNumberOfTrial()

        val cars = createCars(numberOfCar)
        ResultView.printStart()
        repeat(numberOfRace) {
            val race = Race(cars)
            race.racing()
            ResultView.printResult(cars)
        }
    }

    private fun createCars(count: Int): List<Car> {
        return List(count) { Car() }
    }
}
