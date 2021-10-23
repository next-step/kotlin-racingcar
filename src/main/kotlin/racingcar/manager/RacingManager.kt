package racingcar.manager

import racingcar.car.Car
import racingcar.engine.CarEngine

class RacingManager constructor(
    private var cars: List<Car>,
    private var engine: CarEngine
) {

    fun race(show: ((List<Car>) -> Unit)? = null) {
        cars.forEach {
            it.movePosition(engine)
        }
        show?.invoke(cars)
    }

    fun getPositions(): List<Int> = cars.map { it.getPosition() }
}
