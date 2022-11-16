package racingcar.service

import racingcar.model.Car
import racingcar.model.MoveFactor

class RacingGame(carCount: Int) {
    constructor(carNames: List<String>) : this(3) {
        cars = carNames.map { Car(it) }
    }

    constructor(cars: Set<Car>) : this(3) {
        this.cars = cars.toList()
    }

    var cars: List<Car> = List(carCount) { Car() }

    fun play() {
        cars.forEach { it.move(MoveFactor.random()) }
    }

    fun winners(): List<Car> {
        val winnerPosition = cars.maxOf { car -> car.position.value }
        return cars.filter { car -> car.position.value == winnerPosition }
    }
}
