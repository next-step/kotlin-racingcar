package racingcar.application.race.factory

import racingcar.domain.car.Car
import racingcar.domain.car.ParticipatingCars
import racingcar.domain.car.engine.MovingEngine

class CarFactory(
    private val movingEngine: MovingEngine
) {
    fun create(count: Int): ParticipatingCars {
        val cars = List(count) { Car(movingEngine) }
        return ParticipatingCars(cars)
    }

    private companion object {
        private const val START_CREATE_COUNT = 1
    }
}
