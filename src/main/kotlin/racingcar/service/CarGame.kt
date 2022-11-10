package racingcar.service

import racingcar.model.Car
import racingcar.model.Score

class CarGame(carCount: Int) {
    val cars: List<Car> = List(carCount) { Car() }

    fun play() {
        cars.forEach { it.move(Score.random()) }
    }

    fun printDashboard(outputSource: (Car) -> Unit) {
        cars.forEach(outputSource)
    }
}
