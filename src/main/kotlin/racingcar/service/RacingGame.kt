package racingcar.service

import racingcar.model.Car
import racingcar.model.MoveFactor

class RacingGame(carCount: Int) {
    val cars: List<Car> = List(carCount) { Car() }

    fun play() {
        cars.forEach { it.move(MoveFactor.random()) }
    }
}
