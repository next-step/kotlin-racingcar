package racingcar.application.race.factory

import racingcar.domain.car.ParticipatingCars
import racingcar.domain.car.Car
import racingcar.domain.car.engine.MovingEngine

class CarFactory(
    private val movingEngine: MovingEngine
) {
    fun create(count: Int): ParticipatingCars {
        val carList = mutableListOf<Car>()
        for (i in 1..count) {
            carList.add(Car(movingEngine))
        }
        return ParticipatingCars(carList.toList())
    }
}
