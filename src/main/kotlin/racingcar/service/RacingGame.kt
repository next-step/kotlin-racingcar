package racingcar.service

import racingcar.model.Car
import racingcar.model.MoveFactor

class RacingGame(carCount: Int) {
    constructor(carNames: List<String>) : this(3) {
        cars = carNames.map { Car(it) }
    }

    var cars: List<Car> = List(carCount) { Car() }

    fun play() {
        cars.forEach { it.move(MoveFactor.random()) }
    }
}
