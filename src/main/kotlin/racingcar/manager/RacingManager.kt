package racingcar.manager

import racingcar.car.Car
import racingcar.engine.CarEngine

class RacingManager(
    private var cars: List<Car>,
    private var engine: CarEngine
) {

    fun race(show: ((List<Car>) -> Unit)? = null) {
        cars.forEach {
            it.movePosition(engine)
        }
        show?.invoke(cars)
    }

    private fun findMaxPosition(): Int? = cars.maxByOrNull { it.getPosition() }?.getPosition()

    fun findWinners(): List<Car> {
        return cars.filter { it.getPosition() == findMaxPosition() }
    }

    fun getPositions(): List<Int> = cars.map { it.getPosition() }
}
