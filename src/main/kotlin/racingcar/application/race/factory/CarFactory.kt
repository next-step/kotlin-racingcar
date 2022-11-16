package racingcar.application.race.factory

import racingcar.domain.car.Car
import racingcar.domain.car.ParticipatingCars
import racingcar.domain.car.engine.MovingEngine

class CarFactory(
    private val movingEngine: MovingEngine
) {
    fun createByCarNames(carNames: List<String>): ParticipatingCars {
        val cars = carNames.map { Car(movingEngine, it) }.toList()
        return ParticipatingCars(cars)
    }
}
