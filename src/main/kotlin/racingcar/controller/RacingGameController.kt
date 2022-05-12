package racingcar.controller

import racingcar.domain.Car
import racingcar.view.inputCarNumber

class RacingGameController {
    fun handle() {
        val cars = createCars(inputCarNumber())
    }

    private fun createCars(carNumber: Int): List<Car> {
        val cars = mutableListOf<Car>()
        repeat(carNumber) {
            cars.add(Car())
        }

        return cars.toList()
    }
}
