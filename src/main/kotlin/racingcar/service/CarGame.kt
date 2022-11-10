package racingcar.service

import racingcar.model.Car

class CarGame(carCount: Int) {
    val cars: List<Car> = List(carCount) { Car() }

    fun play() {
        cars.forEach { it.move(4) }
    }

    fun printDashboard(outputSource: (Car) -> Unit) {
        cars.forEach(outputSource)
    }
}
